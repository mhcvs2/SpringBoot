package com.mhc.mybatis2.controller;

import com.mhc.mybatis2.model.User;
import com.mhc.mybatis2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public int add(User user) {
        return userService.addUser(user);
    }

    @PostMapping("/add2")
    public int add2(User user){
        return userService.addUser2(user);
    }

}
