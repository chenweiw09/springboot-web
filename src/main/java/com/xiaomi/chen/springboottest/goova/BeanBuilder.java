package com.xiaomi.chen.springboottest.goova;

import groovy.lang.GroovyClassLoader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/7/20
 * @description
 */
@Component
public class BeanBuilder implements ApplicationContextAware {

    private ApplicationContext context;

    String script = "package com.xiaomi.chen.springboottest.goova;\n" +
            "\n" +
            "import org.springframework.stereotype.Component;\n" +
            "\n" +
            "/**\n" +
            " * @author chenwei\n" +
            " * @version 1.0\n" +
            " * @date 2018/10/24\n" +
            " * @description\n" +
            " */\n" +
            "@Component\n" +
            "public class GoovaTestIFaceImpl implements GoovaTestIface {\n" +
            "\n" +
            "\n" +
            "    @Override\n" +
            "    public String hello() {\n" +
            "        return \"这是goova里的容器内容\";\n" +
            "    }\n" +
            "}";





    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.context = applicationContext;
        Class clazz = new GroovyClassLoader().parseClass(script);

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);

        BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();

        context.getAutowireCapableBeanFactory().applyBeanPostProcessorsAfterInitialization(beanDefinition, clazz.getSimpleName());

        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
        beanFactory.registerBeanDefinition(clazz.getSimpleName(), beanDefinition);

        System.out.println("register BeanDefinition-------"+clazz.getSimpleName());
    }
}
