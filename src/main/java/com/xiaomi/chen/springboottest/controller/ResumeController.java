package com.xiaomi.chen.springboottest.controller;

import com.xiaomi.chen.springboottest.domain.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/12/11
 * @description
 */
@Slf4j
@Controller
@RequestMapping("/resume")
public class ResumeController {


    @GetMapping("/liuchang")
    public String indexPage(HttpServletRequest request, HttpServletResponse response){
        return  "liuchang";
    }


    @GetMapping("/liuchang/myresume")
    public String resumePage(){
        return "resume";
    }


    @GetMapping("/preview")
    public void getResume(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String path = "/"+Constants.fileDir+"upload"+File.separator+"liuchang.pdf";

        response.setHeader("Access-Control-Allow-Origin", "*");
        OutputStream outputStream = response.getOutputStream();
        getFileOutputStream(path,outputStream);

    }


    private void getFileOutputStream(String path, OutputStream outputStream){
        log.info("开始打印文件的地址|path:"+path);
        File pdfFile = new File(path);
        if(pdfFile.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(pdfFile);
                IOUtils.write(IOUtils.toByteArray(fileInputStream), outputStream);
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                log.error("",e);
            }
        }else{
            log.error("没有文件");
        }
    }
}
