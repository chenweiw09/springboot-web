package com.xiaomi.chen.springboottest.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/12/13
 * @description
 */
@Controller
public class MyErrorController implements ErrorController {


    @GetMapping("/error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == HttpStatus.UNAUTHORIZED.value()){
            return "/error";
        }else if(statusCode == HttpStatus.NOT_FOUND.value()){
            return "/error";
        }else if(statusCode == HttpStatus.FORBIDDEN.value()){
            return "/error";
        }else{
            return "/error";
        }

    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
