package com.xiaomi.chen.springboottest.exceptions;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.util.NestedServletException;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/10/24
 * @description
 */
public class ExceptionUtil {

    public static void throwException(ExceptionType type) throws MyException{
        throw new MyException(type);
    }

    static MyException convert(Throwable e){
        if(e instanceof UndeclaredThrowableException || e instanceof NestedServletException){
            e = e.getCause();
        }

        if(e instanceof MyException){
            return (MyException) e;
        }

        if(e instanceof MissingServletRequestParameterException){
            return new MyException(ExceptionType.ILLEGAL_ARG);
        }

        return new MyException(ExceptionType.UNKNOWN);
    }
}
