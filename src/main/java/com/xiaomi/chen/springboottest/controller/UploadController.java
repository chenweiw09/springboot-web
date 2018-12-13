package com.xiaomi.chen.springboottest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/9/28
 * @description
 */
@RestController
public class UploadController {

    @PostMapping("/upload")
    public String upload(HttpServletRequest request, MultipartFile file){

        String dir = request.getServletContext().getRealPath("/")+"upload/";

        try {
            File dirFile = new File(dir);
            if(!dirFile.exists()){
                dirFile.mkdir();
            }

            String fileName = file.getOriginalFilename();
            File serverFile = new File(dir+fileName);
            file.transferTo(serverFile);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
    }
}
