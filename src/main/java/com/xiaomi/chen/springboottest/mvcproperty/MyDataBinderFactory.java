package com.xiaomi.chen.springboottest.mvcproperty;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.InvocableHandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ServletRequestDataBinderFactory;

import java.util.List;

/**
 * Created by Wei Chen on 13:51 2018/7/11.
 */
public class MyDataBinderFactory extends ServletRequestDataBinderFactory {


    public MyDataBinderFactory(List<InvocableHandlerMethod> binderMethods, WebBindingInitializer initializer) {
        super(binderMethods, initializer);
    }

    @Override
    protected ServletRequestDataBinder createBinderInstance(Object target, String objectName, NativeWebRequest request) {
        return new SnakeToCamelRequestDataBinder(target, objectName);
    }
}
