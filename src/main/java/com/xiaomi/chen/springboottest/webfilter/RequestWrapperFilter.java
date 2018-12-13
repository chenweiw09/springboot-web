package com.xiaomi.chen.springboottest.webfilter;

import com.xiaomi.chen.springboottest.servletwrapper.MyHttpServletRequestWrapper;
import com.xiaomi.chen.springboottest.servletwrapper.MyHttpServletResponseWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/10/25
 * @description
 */
@Slf4j
public class RequestWrapperFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        filterConfig.getInitParameterNames();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(!(servletRequest instanceof HttpServletRequest || servletResponse instanceof HttpServletResponse)){
            return;
        }

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        MyHttpServletRequestWrapper requestWrapper = new MyHttpServletRequestWrapper(httpRequest);
        log.info(requestWrapper.getRequestURI() + " " + requestWrapper.getContent());

        filterChain.doFilter(httpRequest,httpResponse);

        MyHttpServletResponseWrapper responseWrapper = new MyHttpServletResponseWrapper(httpResponse);
        log.info(requestWrapper.getRequestURI() + " " + responseWrapper.getContent());
        httpResponse.getOutputStream().write(responseWrapper.getContentAsBytes());


    }

    @Override
    public void destroy() {

    }
}
