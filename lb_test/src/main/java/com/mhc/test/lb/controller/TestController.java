package com.mhc.test.lb.controller;

import com.mhc.test.lb.config.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    TestProperties testProperties;

    @GetMapping("")
    public String getName(){
        return testProperties.getName();
    }
}
