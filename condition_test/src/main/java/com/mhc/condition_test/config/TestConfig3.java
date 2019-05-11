package com.mhc.condition_test.config;

import com.mhc.condition_test.model.TestUser1;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(value = {TestUser1.class, TestConfig1.class})
//@ConditionalOnClass(name = "com.mhc.condition_test.model.TestUser1")
public class TestConfig3 {

    private String key1;
}
