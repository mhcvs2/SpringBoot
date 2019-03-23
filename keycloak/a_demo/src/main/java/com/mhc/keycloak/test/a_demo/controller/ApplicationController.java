package com.mhc.keycloak.test.a_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @RequestMapping(value = "/api/resourcea", method = RequestMethod.GET)
    public String handleResourceA() {
        return "Access Granted in my own demo api a";
    }

    @RequestMapping(value = "/api/resourceb", method = RequestMethod.GET)
    public String handleResourceAB() {
        return "Access Granted in my own demo api b";
    }

    @RequestMapping(value = "/apj/resourceb", method = RequestMethod.GET)
    public String handleResourceB() {
        return "Access Granted in my own demo apj b";
    }
}