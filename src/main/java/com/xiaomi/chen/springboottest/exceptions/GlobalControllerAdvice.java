package com.xiaomi.chen.springboottest.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Wei Chen on 17:41 2018/6/26.
 */

@ControllerAdvice
public class GlobalControllerAdvice {


    private static final Logger logger = LoggerFactory.getLogger(GlobalControllerAdvice.class);


    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Object handleException(HttpServletRequest request, HttpServletResponse response, Throwable e) {
        response.setStatus(412);
        MyException exception = ExceptionUtil.convert(e);

        logger.warn("handleException|error handle:" + request.getRequestURI() + "|e:" + e.getMessage());

        return exception;
    }
}
