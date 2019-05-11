package com.mhc.condition_test.config;

import com.mhc.condition_test.condition.TestCondition1;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(TestCondition1.class)
public class TestConfig4 {
    private String key1;
}
