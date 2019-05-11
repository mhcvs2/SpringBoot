package com.mhc.configuration_test.configurationProperties.b;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class testConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "mail")
    public MailProperties2 mailProperties2(){
        return new MailProperties2();
    }

}
