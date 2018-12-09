package com.mhc.nginx_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nt")
public class NtController {

    @Autowired
    NginxTestProperties nginxTestProperties;

    @GetMapping
    public String t1() {
        return "I am 'nt', my name is " + nginxTestProperties.getName();
    }

}
