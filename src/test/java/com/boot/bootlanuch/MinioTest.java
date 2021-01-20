package com.boot.bootlanuch;

import com.boot.bootlanuch.utils.MinioUtils;
import io.minio.ObjectWriteResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MinioTest {
    @Resource
    private MinioUtils minioUtils;

    @Test
    public void createBucket() throws Exception {
        minioUtils.makeBucket("boot-lanuch");
    }

    @Test
    public void putObject() throws Exception {
        ObjectWriteResponse response = minioUtils.putObject("boot-lanuch"
                , "doc/spark学习.docx"
                , "F:\\Document And Settings2\\Administrator\\Desktop\\spark学习\\spark学习.docx"
        );
        ObjectWriteResponse response2 = minioUtils.putObject("boot-lanuch"
                , "doc/spark学习2.docx"
                , "F:\\Document And Settings2\\Administrator\\Desktop\\spark学习\\spark学习.docx"
        );
        System.out.println(response.object());
    }

    @Test
    public void delete() throws Exception {
        minioUtils.deleteObject("boot-lanuch"
                , "docx/spark学习2.docx");
        minioUtils.deleteObject("boot-lanuch"
                , "docx/spark学习.docx");
    }
}
