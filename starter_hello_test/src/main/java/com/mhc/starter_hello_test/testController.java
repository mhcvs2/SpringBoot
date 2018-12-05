package com.mhc.starter_hello_test;

import com.wisely.spring_boot_starter_hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @Autowired
    HelloService helloService;

    @GetMapping("/1")
    public String t1(){
        return helloService.sayHello();
    }

}
