package com.mhc.test.hystrix.service1.controller;

import com.mhc.test.hystrix.common.model.User;
import com.mhc.test.hystrix.service1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping("/t1/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PostMapping("/t1")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }


}
