package com.xiaomi.chen.springboottest.core

import org.springframework.beans.BeanUtils
import org.springframework.beans.BeanWrapper
import org.springframework.beans.PropertyAccessorFactory
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/9/29
 * @description
 */
@Component
class SnakeToCamelArgumentResolver : HandlerMethodArgumentResolver {

    override fun supportsParameter(methodParameter: MethodParameter): Boolean {
        if (methodParameter.hasParameterAnnotation(RequestParam::class.java)) {
            println("--------paramname:" + methodParameter.parameterName!!)
        }
        return methodParameter.parameterName.contains("_") || methodParameter.hasParameterAnnotation(RequestParam::class.java)
    }

    @Throws(Exception::class)
    override fun resolveArgument(methodParameter: MethodParameter, modelAndViewContainer: ModelAndViewContainer?, nativeWebRequest: NativeWebRequest, webDataBinderFactory: WebDataBinderFactory?): Any? {
        return handleParameterNames(methodParameter, nativeWebRequest)
    }

    private fun handleParameterNames(parameter: MethodParameter, webRequest: NativeWebRequest): Any {
        val obj = BeanUtils.instantiate(parameter.parameterType)
        val wrapper = PropertyAccessorFactory.forBeanPropertyAccess(obj)
        val paramNames = webRequest.parameterNames
        while (paramNames.hasNext()) {
            val paramName = paramNames.next()
            val o = webRequest.getParameter(paramName)
            wrapper.setPropertyValue(underLineToCamel(paramName), o)
        }
        return obj
    }

    private fun underLineToCamel(source: String): String {
        val matcher = Pattern.compile("_(\\w)").matcher(source)
        val sb = StringBuffer()
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase())
        }
        matcher.appendTail(sb)
        return sb.toString()
    }
}