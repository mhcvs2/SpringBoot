package com.easy.springBoot.bms.config

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
import org.springframework.boot.web.servlet.ErrorPage
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.http.HttpStatus


@Configuration
class ErrorConfig {

    @Bean
    @Primary
    EmbeddedServletContainerCustomizer containerCustomizer(){
        new EmbeddedServletContainerCustomizer(){
            @Override
            void customize(ConfigurableEmbeddedServletContainer container){
                container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"))
            }
        }
    }
}
