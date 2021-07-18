package com.mhc.test.lb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "test")
@Data
public class TestProperties {

    private String name = System.getenv("TEST_NAME");

}
