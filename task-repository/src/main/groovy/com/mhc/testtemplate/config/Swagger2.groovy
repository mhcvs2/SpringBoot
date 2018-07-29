package com.mhc.testtemplate.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class Swagger2 {

    @Bean
    @Primary
    Docket createRestApi(){
        new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.mhc.testtemplate.controller"))
                .paths(PathSelectors.any())
                .build()
    }

    private static ApiInfo apiInfo(){
        new ApiInfoBuilder()
                .title("MHC Project")
                .description("description")
                .termsOfServiceUrl("http://test.com")
                .contact("hongchao.ma")
                .version("1.0")
                .build()
    }
}
