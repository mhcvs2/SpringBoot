package com.mhc.springboot_threadpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class SpringbootThreadpoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootThreadpoolApplication.class, args);
    }
}
