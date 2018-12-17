package com.xiaomi.chen.springboottest.core

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/9/20
 * @description
 */
@Configuration
@EnableSwagger2
//@EnableWebMvc
open class SwaggerConfig : WebMvcConfigurerAdapter() {

    // 需要加这一块，不然访问不到
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/")

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
    }


    @Bean
    open fun buildDocket(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select().apis(RequestHandlerSelectors.basePackage("com.xiaomi.chen.springboottest.controller"))//controller路径
                .paths(PathSelectors.any())
                .build()
    }

    private fun buildApiInf(): ApiInfo {
        return ApiInfoBuilder()
                .title("接口输出报告")
                .termsOfServiceUrl("http://localhost:8080")
                .description("springmvc swagger2")
                //                .contact(new Contact("xxxx", "http://blog.csdn.net/u014231523", "xxx@163.com"))
                .build()

    }
}
