package com.xiaomi.chen.springboottest.controller;

import com.xiaomi.chen.springboottest.domain.User;
import com.xiaomi.chen.springboottest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/9/28
 * @description
 */
@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    private static final String USER_NAME = "userName";
    private static final String USER_ID = "userId";


    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("login")
    public void userLogin(@RequestParam String userName, @RequestParam String password,
                          HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = userService.getUserByUserName(userName);

        if(!user.getPassword().equals(password)){
            log.error("error user password");
            response.sendRedirect(request.getContextPath()+"/login");
        }

        request.getSession().setAttribute(USER_NAME,user.getUserName());
        request.getSession().setAttribute(USER_ID,user.getUserId());
        response.sendRedirect(request.getContextPath()+"/upload");
    }

    @GetMapping("/upload")
    public String index(){
        return "upload";
    }
}
