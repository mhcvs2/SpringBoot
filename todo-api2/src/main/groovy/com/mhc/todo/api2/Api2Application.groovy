package com.mhc.todo.api2

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@MapperScan('com.mhc.todo.api2.mapper')
class Api2Application {

    static void main(String[] args) {
        SpringApplication.run Api2Application, args
    }
}
