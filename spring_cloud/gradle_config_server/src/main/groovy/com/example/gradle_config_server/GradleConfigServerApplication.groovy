package com.example.gradle_config_server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class GradleConfigServerApplication {

    static void main(String[] args) {
        SpringApplication.run GradleConfigServerApplication, args
    }
}

