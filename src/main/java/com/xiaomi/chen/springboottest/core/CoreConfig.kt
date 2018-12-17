package com.xiaomi.chen.springboottest.core

import com.fasterxml.jackson.databind.*
import org.springframework.boot.web.server.ConfigurableWebServerFactory
import org.springframework.boot.web.server.ErrorPage
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

import java.nio.charset.Charset
import java.util.ArrayList

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/9/28
 * @description
 */
@Configuration
open class CoreConfig {

    @Bean
    open fun mappingJackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter {
        return MappingJackson2HttpMessageConverter(objectMapper())
    }

    @Bean
    open fun stringHttpMessageConverter(): StringHttpMessageConverter {
        val converter = StringHttpMessageConverter(Charset.forName("UTF-8")).apply {
            supportedMediaTypes = mutableListOf(MediaType.APPLICATION_JSON_UTF8, MediaType(MediaType.TEXT_HTML, Charset.forName("UTF-8")))
        }

        return converter
    }


    @Bean
    open fun objectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper().let {
            // 禁用空对象转换json校验
            it.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)

            it.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            // 只有当set和get同时存在的时候，才进行json化，避免idl文件生成的很多不需要的属性
            it.configure(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS, true)
            // 所有参数输出都是下划线形式
            it.propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
            it.propertyNamingStrategy = PropertyNamingStrategy.SnakeCaseStrategy()

            it
        }

        return objectMapper

    }

    //    @Bean
    //    public PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy lowerCaseWithUnderscoresStrategy(){
    //
    //    }


}
