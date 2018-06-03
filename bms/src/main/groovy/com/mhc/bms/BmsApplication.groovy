package com.mhc.bms

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@MapperScan('com.mhc.bms.mapper')
class BmsApplication {

    static void main(String[] args) {
        SpringApplication.run BmsApplication, args
    }
}
