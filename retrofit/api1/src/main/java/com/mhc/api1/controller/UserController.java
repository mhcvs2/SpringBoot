package com.mhc.api1.controller;

import com.mhc.api1.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/add")
    public int add(@RequestBody User user) {
        System.out.println("add user, id " + user.getId() + " name " + user.getName());
        return user.getId();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User get(@PathVariable int id){
        User res = new User();
        res.setId(id);
        res.setName("mhc");
        return res;
    }

}
