package com.xiaomi.chen.springboottest.core

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.IOException
import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/9/29
 * @description
 */
@Configuration
open class WebFilterConfig {

    private val DEFAULT_CHAR = "UTF-8"

    @Bean
    open fun filterRegistrationBean(): FilterRegistrationBean<MyFilter> {
        val registration = FilterRegistrationBean(MyFilter()).let {
            //设置过滤路径，/*所有路径
            it.addUrlPatterns("/*")
            //添加默认参数
            it.addInitParameter("name", "alue")
            it.setName("MyFilter")
            //设置优先级
            it.order=100
            it
        }
        return registration
    }


    @Bean
    open fun filterRegistrationBean1(): FilterRegistrationBean<*> {
        val registration = FilterRegistrationBean(CharacterEncodingFilter()).apply {
            addUrlPatterns("/*")
            setName("CharacterEncodingFilter")
            order = 99
        }
        return registration
    }


    inner class MyFilter : Filter {

        @Throws(ServletException::class)
        override fun init(filterConfig: FilterConfig) {}

        @Throws(IOException::class, ServletException::class)
        override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
            val request = servletRequest as HttpServletRequest
            //打印请求Url
            println("this is MyFilter,url :" + request.requestURI)
            filterChain.doFilter(servletRequest, servletResponse)
        }

        override fun destroy() {}
    }

    inner class CharacterEncodingFilter : Filter {
        private var filterConfig: FilterConfig? = null

        @Throws(ServletException::class)
        override fun init(filterConfig: FilterConfig) {
            this.filterConfig = filterConfig
        }

        @Throws(IOException::class, ServletException::class)
        override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
            val request = servletRequest as HttpServletRequest
            val response = servletResponse as HttpServletResponse
            request.characterEncoding = DEFAULT_CHAR
            response.contentType = "text/html;charset=" + DEFAULT_CHAR
            filterChain.doFilter(request, response)
        }

        override fun destroy() {
            println("destroy CharacterEncodingFilter")
        }

    }
}
