package com.mhc.test.hystrix.service1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Service1Configuraton {

    @Bean
    public RestTemplate genRestTemplate(){
        return new RestTemplate();
    }

}
