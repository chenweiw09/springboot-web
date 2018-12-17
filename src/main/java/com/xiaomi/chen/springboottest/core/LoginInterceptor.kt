package com.xiaomi.chen.springboottest.core

import org.springframework.lang.Nullable
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
open class LoginInterceptor : HandlerInterceptor {

    @Throws(Exception::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any?): Boolean {
        println("------------interceptor")
        val userName = request.session.getAttribute(USER_NAME)
        val userId = request.session.getAttribute(USER_ID)
        if (userName == null || userId == null) {
            response.sendRedirect(request.contextPath + "/login")
        }
        return true
    }

    @Throws(Exception::class)
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any?, @Nullable modelAndView: ModelAndView?) {
    }

    @Throws(Exception::class)
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any?, @Nullable ex: Exception?) {
    }

    companion object {

        val USER_NAME = "userName"
        val USER_ID = "userId"
    }
}
