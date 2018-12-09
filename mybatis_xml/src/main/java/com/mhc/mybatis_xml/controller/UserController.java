package com.mhc.mybatis_xml.controller;

import com.mhc.mybatis_xml.model.User;
import com.mhc.mybatis_xml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(User user) {
        return userService.addUser(user);
    }

}
