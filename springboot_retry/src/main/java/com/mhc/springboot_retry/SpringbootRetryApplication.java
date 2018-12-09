package com.mhc.springboot_retry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
@EnableAspectJAutoProxy(exposeProxy = true)
public class SpringbootRetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRetryApplication.class, args);
    }
}
