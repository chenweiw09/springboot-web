package com.xiaomi.chen.springboottest.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import java.util.List;

@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter {


    @Resource
    private LoginInterceptor loginInterceptor;

    @Resource
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Resource
    private LoggerInterceptor loggerInterceptor;

    @Resource
    private SnakeToCamelArgumentResolver snakeToCamelArgumentResolver;

    /**
     * 配置静态访问资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/WEB_INF/static/");
        super.addResourceHandlers(registry);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry){
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/toLogin","/login**","/static/**",
                "/resume/**","/plugins/**");
        registry.addInterceptor(loggerInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }



    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        super.configureMessageConverters(converters);
        converters.add(mappingJackson2HttpMessageConverter);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
        argumentResolvers.add(snakeToCamelArgumentResolver);
        super.addArgumentResolvers(argumentResolvers);
    }



}
