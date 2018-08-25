package com.wisely.ch6_5_2;

import com.wisely.spring_boot_starter_hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ch652Application {

    @Autowired
    HelloService helloService;

    @RequestMapping("/")
    public String index(){
        return helloService.sayHello();
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch652Application.class, args);
    }
}
