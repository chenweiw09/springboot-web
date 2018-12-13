package com.xiaomi.chen.springboottest.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/10/24
 * @description
 */
public class MyException extends Exception{

    @Setter
    @Getter
    private int code;

    @Getter
    @Setter
    private String msg;

    public MyException(int code) {
        super();
        this.code = code;
    }

    public MyException(int code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.msg = message;
    }

    public MyException(ExceptionType type) {
        super(type.getDesc());
        this.code = type.getCode();
        this.msg = type.getDesc();
    }
}
