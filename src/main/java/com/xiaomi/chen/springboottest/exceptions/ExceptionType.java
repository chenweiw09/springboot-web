package com.xiaomi.chen.springboottest.exceptions;

/**
 * Created by Wei Chen on 14:17 2018/10/24.
 */
public enum ExceptionType {

    UNKNOWN(1, "系统繁忙"),
    ILLEGAL_ARG(2, "参数错误", IllegalArgumentException.class, NullPointerException.class),
    LOGIN_FAIL(3,"没有登录"),

    ;



    ExceptionType(int code, String desc, Class<? extends Throwable>... boundExceptions) {
        this.code = code;
        this.desc = desc;
    }

    private int code;

    private String desc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
