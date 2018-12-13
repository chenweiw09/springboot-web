package com.xiaomi.chen.springboottest.core;

import com.xiaomi.chen.springboottest.utils.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/9/28
 * @description
 */
@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

    private static final String LOGGER_TIME = "LOGGER_SEND_TIME";
    private static final String LOGGER_ENTITY = "LOGGER_ENTITY";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        String paramData = JSONUtil.toJSONString(request.getParameterMap());
        String header = JSONUtil.toJSONString(getHeaders(request));

        String method = request.getMethod();
        String entity  = "请求uri:"+url+"|请求方法:"+method+"|paramData:"+paramData+"|headers:"+header;
        logger.info(entity);
        request.setAttribute(LOGGER_TIME,System.currentTimeMillis());
        request.setAttribute(LOGGER_ENTITY,entity);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        int status = response.getStatus();

        long time = System.currentTimeMillis()-(long)request.getAttribute(LOGGER_TIME);

        logger.info(request.getAttribute(LOGGER_ENTITY)+"|status:"+status+"|耗时:"+time);

    }




    private Map<String, Object> getHeaders(HttpServletRequest request){
        Enumeration<String> ems =  request.getHeaderNames();
        Map<String, Object> map = new HashMap<>();

        while (ems.hasMoreElements()){
            String headerName = ems.nextElement();
            map.put(headerName, request.getHeader(headerName.toLowerCase()));
        }

        return map;
    }
}
