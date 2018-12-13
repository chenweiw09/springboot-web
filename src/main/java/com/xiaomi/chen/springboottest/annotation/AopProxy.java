package com.xiaomi.chen.springboottest.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/10/16
 * @description
 */
@Aspect
@Slf4j
public class AopProxy {

    @Pointcut("@annotation(com.xiaomi.chen.common.annotation.RpcInterface),@within(com.xiaomi.chen.springboottest.rpc.annotation.RpcInterface)")
    public void pointcut() {
    }

    @After("pointcut()")
    public Object after(final ProceedingJoinPoint proceedingJoinPoint) throws IOException {
        return null;
    }
}
