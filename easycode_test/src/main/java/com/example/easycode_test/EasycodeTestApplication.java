package com.example.easycode_test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.easycode_test.dao")
public class EasycodeTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasycodeTestApplication.class, args);
    }

}

