package com.mhc.filter_interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/1")
    public void t1(){
        System.out.println("Hello world!");
    }
//    FirstInterceptor preHandle
//    TwoInterceptor preHandle
//    Hello world!
//    TwoInterceptor postHandle
//    FirstInterceptor postHandle
//    TwoInterceptor afterCompletion
//    FirstInterceptor afterCompletion

}
