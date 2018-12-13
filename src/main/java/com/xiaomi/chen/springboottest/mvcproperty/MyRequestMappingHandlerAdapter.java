package com.xiaomi.chen.springboottest.mvcproperty;

import org.springframework.web.method.annotation.InitBinderDataBinderFactory;
import org.springframework.web.method.support.InvocableHandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.List;

/**
 * Created by Wei Chen on 13:49 2018/7/11.
 */
public class MyRequestMappingHandlerAdapter extends RequestMappingHandlerAdapter {

    @Override
    protected InitBinderDataBinderFactory createDataBinderFactory(List<InvocableHandlerMethod> binderMethods) throws Exception {
        return new MyDataBinderFactory(binderMethods, getWebBindingInitializer());
    }
}
