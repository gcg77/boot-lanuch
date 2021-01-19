package com.boot.bootlanuch.controller;

import com.boot.bootlanuch.response.RestResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.security.jgss.HttpCaller;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author admin
 */
@RestController
public class UploadController {
    @Value("${web.upload-path}")
    private String uploadPath;
    @Value("${server.servlet.context-path}")
    private String bootLanuch;
    @PostMapping("/file/upload")
    public RestResponse upload(MultipartFile uploadFile , HttpServletRequest request) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        String format=sdf.format(new Date());
        File folder=new File(uploadPath+format);
        if(!folder.isDirectory()){
            folder.mkdirs();
        }
        String oldName =uploadFile.getOriginalFilename();
        String newName= UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."),oldName.length());
        uploadFile.transferTo(new File(folder,newName));
        String filePath = request.getScheme()+"://"+request.getServerName()
                +":"+request.getServerPort()+bootLanuch+"/"+format+newName;
        return RestResponse.success().put("data",filePath);
    }

}
