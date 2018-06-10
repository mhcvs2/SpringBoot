package com.easy.springBoot.bms

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
@MapperScan('com.easy.springBoot.bms.mapper')
class Application {
    static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }
}
