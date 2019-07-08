package com.mhc.condition_test.config;

import com.mhc.condition_test.service.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "test1")
//@ConditionalOnProperty(prefix = "test1", name = "key1", havingValue = "haha", matchIfMissing = true)
public class TestConfig1 {

    @Autowired
    TestInterface testInterface;

    public static class Sub1 {
        public String key1;
    }

    private String key1;
    private Integer key2;

    private Sub1 sub1;
}
