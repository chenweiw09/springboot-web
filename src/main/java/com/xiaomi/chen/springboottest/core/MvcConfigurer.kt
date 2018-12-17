package com.xiaomi.chen.springboottest.core

import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import javax.annotation.Resource

@Configuration
open class MvcConfigurer(@Resource private val snakeToCamelArgumentResolver: SnakeToCamelArgumentResolver,
                         @Resource private val loginInterceptor: LoginInterceptor
        ): WebMvcConfigurerAdapter() {

    @Resource
    private val mappingJackson2HttpMessageConverter: MappingJackson2HttpMessageConverter? = null

    @Resource
    private val loggerInterceptor: LoggerInterceptor? = null

//    @Resource
//    private val snakeToCamelArgumentResolver: SnakeToCamelArgumentResolver? = null

    /**
     * 配置静态访问资源
     * @param registry
     */
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/WEB_INF/static/")
        super.addResourceHandlers(registry)
    }


    override fun addInterceptors(registry: InterceptorRegistry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/toLogin", "/login**", "/static/**",
                "/resume/**", "/plugins/**", "/WEB-INF/**")
        registry.addInterceptor(loggerInterceptor).addPathPatterns("/**")
        super.addInterceptors(registry)
    }


    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        mappingJackson2HttpMessageConverter?.let { converters.add(it) }
        super.configureMessageConverters(converters)
    }

    override fun addArgumentResolvers(argumentResolvers: MutableList<HandlerMethodArgumentResolver>) {
        argumentResolvers?.let {
            it.add(snakeToCamelArgumentResolver)
        }
        super.addArgumentResolvers(argumentResolvers)
    }


}
