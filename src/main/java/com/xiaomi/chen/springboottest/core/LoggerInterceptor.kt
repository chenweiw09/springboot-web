package com.xiaomi.chen.springboottest.core

import com.xiaomi.chen.springboottest.utils.JSONUtil
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.lang.Nullable
import org.springframework.stereotype.Component
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.util.Enumeration
import java.util.HashMap

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/9/28
 * @description
 */
@Component
class LoggerInterceptor : HandlerInterceptorAdapter() {


    @Throws(Exception::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any?): Boolean {
        val url = request.requestURI
        val paramData = JSONUtil.toJSONString(request.parameterMap)
        val header = JSONUtil.toJSONString(getHeaders(request))

        val method = request.method
        val entity = "请求uri:$url|请求方法:$method|paramData:$paramData|headers:$header"
        logger.info(entity)
        request.setAttribute(LOGGER_TIME, System.currentTimeMillis())
        request.setAttribute(LOGGER_ENTITY, entity)
        return true
    }

    @Throws(Exception::class)
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, @Nullable ex: Exception?) {

        val time = System.currentTimeMillis() - request.getAttribute(LOGGER_TIME) as Long

        logger.info(request.getAttribute(LOGGER_ENTITY).toString() + "|status:" + response.status + "|耗时:" + time)

    }


    private fun getHeaders(request: HttpServletRequest): Map<String, Any> {
        val ems = request.headerNames

        val map = HashMap<String, Any>()

        while (ems.hasMoreElements()) {
            val headerName = ems.nextElement()
            map.put(headerName, request.getHeader(headerName.toLowerCase()))
        }

        return map
    }

    companion object {

        val logger = LoggerFactory.getLogger(LoggerInterceptor::class.java)
        val LOGGER_TIME = "LOGGER_SEND_TIME"
        val LOGGER_ENTITY = "LOGGER_ENTITY"
    }
}
