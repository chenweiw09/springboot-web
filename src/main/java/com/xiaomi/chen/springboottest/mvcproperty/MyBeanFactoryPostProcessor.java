package com.xiaomi.chen.springboottest.mvcproperty;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * Created by Wei Chen on 9:35 2018/7/5.
 */
//@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("-----------------------------");
        RootBeanDefinition mbd = (RootBeanDefinition) beanFactory.getBeanDefinition(RequestMappingHandlerAdapter.class.getName());
        mbd.setBeanClass(MyRequestMappingHandlerAdapter.class);

    }
}
