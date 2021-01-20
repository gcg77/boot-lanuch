package com.boot.bootlanuch.utils;

import io.minio.*;
import io.minio.messages.Bucket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author admin
 */
@Slf4j
@Component
public class MinioUtils {
    @Value("${minio.endpoint}")
    private String endpoint;
    @Value("${minio.port}")
    private Integer port;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;


    private MinioClient instance;

    /**
     * minio操作对象实例化
     */
    @PostConstruct
    public void init() {
        instance = MinioClient.builder()
                .endpoint(endpoint, port, false)
                .credentials(accessKey, secretKey)
                .build();
    }

    /**
     * 判断bucket是否存在
     *
     * @param bucketName
     * @return
     * @throws Exception
     */
    public boolean bucketExists(String bucketName) throws Exception {
        return instance.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    /**
     * 创建bucket
     *
     * @param bucketName
     * @throws Exception
     */
    public void makeBucket(String bucketName) throws Exception {
        boolean isExist = this.bucketExists(bucketName);
        if (!isExist) {
            instance.makeBucket(MakeBucketArgs.builder().
                    bucket(bucketName).build());
        }
    }

    /**
     * @return java.util.List<io.minio.messages.Bucket>
     * @Description 获取minio所有的桶
     **/
    public List<Bucket> getAllBucket() throws Exception {
        // 获取minio中所以的bucket
        List<Bucket> buckets = instance.listBuckets();
        for (Bucket bucket : buckets) {
            log.info("bucket 名称:  {}      bucket 创建时间: {}", bucket.name(), bucket.creationDate());
        }
        return buckets;
    }


    /**
     * 将图片上传到minio服务器
     *
     * @param inputStream
     * @param bucketName
     * @param objectName
     */
    public ObjectWriteResponse putObject(String bucketName, String objectName, InputStream inputStream) throws Exception {
        return instance.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .stream(inputStream, -1,10485760)
                .build());
    }

    /**
     * @param filePath   文件路径
     * @param bucketName bucket名称
     * @param objectName 对象名称
     * @return
     * @throws Exception
     */
    public ObjectWriteResponse putObject(String bucketName, String objectName, String filePath) throws Exception {
        return instance.uploadObject(
                UploadObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .filename(filePath)
                        .build()
        );
    }

    /**
     * @param objectName: 对象的名称
     * @return java.lang.String
     * @Description 根据指定的objectName获取下载链接，需要bucket设置可下载的策略
     **/
    public String getUrlByObjectName(String objectName,String bucketName) throws Exception{
        String objectUrl = instance.getObjectUrl(bucketName, objectName);
        return objectUrl;
    }


    /**
     * @param objectName: objectName
     * @param fileName:   文件名称
     * @param dir:        文件目录
     * @return void
     * @Description 根据objectName从minio中下载文件到指定的目录
     **/
    public void downloadImageFromMinioToFile(String bucketName,String objectName, String fileName, String dir) throws Exception {
        GetObjectArgs objectArgs = GetObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .build();
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        InputStream inputStream = instance.getObject(objectArgs);
        FileOutputStream outputStream = new FileOutputStream(new File(dir, fileName.substring(fileName.lastIndexOf("/") + 1)));
        int length;
        byte[] buffer = new byte[1024];
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.close();
        inputStream.close();
    }

    /**
     *
     * @param bucketName
     * @param objectName
     */
    public void deleteObject(String bucketName,String objectName) throws Exception{
     instance.removeObject(RemoveObjectArgs.builder()
             .bucket(bucketName)
             .object(objectName)
             .build());
    }
}