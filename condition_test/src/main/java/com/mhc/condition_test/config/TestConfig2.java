package com.mhc.condition_test.config;

import com.mhc.condition_test.annotation.TestAnnotation1;
import com.mhc.condition_test.annotation.TestAnnotation2;
import com.mhc.condition_test.service.TestService1;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnBean(value = {TestConfig1.class, TestService1.class})
//@ConditionalOnBean(type = {"com.mhc.condition_test.service.TestService1"})
//@ConditionalOnBean(annotation = {TestAnnotation1.class, TestAnnotation2.class})
//@ConditionalOnBean(name = {"testService1", "testService2"}, search = SearchStrategy.CURRENT)
@ConditionalOnMissingBean(value = TestConfig1.class, ignored = TestConfig1.class)
public class TestConfig2 {

    private String key1;
}
