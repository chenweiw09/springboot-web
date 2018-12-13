package com.xiaomi.chen.springboottest.core;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/9/29
 * @description
 */
@Configuration
public class WebFilterConfig {


    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //添加过滤器
        registration.setFilter(new MyFilter());
        //设置过滤路径，/*所有路径
        registration.addUrlPatterns("/*");
        //添加默认参数
        registration.addInitParameter("name", "alue");
        registration.setName("MyFilter");
        //设置优先级
        registration.setOrder(1);
        return registration;
    }


    @Bean
    public FilterRegistrationBean filterRegistrationBean1(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //添加过滤器
        registration.setFilter(new CharacterEncodingFilter());
        //设置过滤路径，/*所有路径
        registration.addUrlPatterns("/*");

        registration.setName("CharacterEncodingFilter");
        //设置优先级
        registration.setOrder(1);
        return registration;
    }



    public class MyFilter implements Filter{

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            //打印请求Url
            System.out.println("this is MyFilter,url :" + request.getRequestURI());
            filterChain.doFilter(servletRequest, servletResponse);
        }

        @Override
        public void destroy() {

        }
    }

    public class CharacterEncodingFilter implements Filter {
        private FilterConfig filterConfig = null;

        //设置默认的字符编码
        private static final String DEFAULT_CHAR = "UTF-8";

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            this.filterConfig = filterConfig;
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            request.setCharacterEncoding(DEFAULT_CHAR);
            response.setContentType("text/html;charset="+DEFAULT_CHAR);
            filterChain.doFilter(request, response);
        }

        @Override
        public void destroy() {
            System.out.println("destroy CharacterEncodingFilter");
        }
    }
}
