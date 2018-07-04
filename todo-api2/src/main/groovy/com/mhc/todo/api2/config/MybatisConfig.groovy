package com.mhc.todo.api2.config

import org.mybatis.spring.boot.autoconfigure.MybatisProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class MybatisConfig {

    @Bean
    @Primary
    MybatisProperties mybatisProperties() {
        MybatisProperties p = new MybatisProperties()
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration()
        config.mapUnderscoreToCamelCase = true
        p.configuration = config
        p
    }

    //允许跨域请求
    @Bean
    @Primary
    WebMvcConfigurer corsConfigurer(){
        new WebMvcConfigurer() {
            @Override
            void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*")
                        .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
            }
        }
    }
}
