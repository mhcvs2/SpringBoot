package com.mhc.gate.controller;

import com.mhc.api1.model.User;
import com.mhc.api2.model.Phone;
import com.mhc.gate.service.Api1Service;
import com.mhc.gate.service.Api2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Test1Controller {

    @Autowired
    Api1Service api1Service;

    @Autowired
    Api2Service api2Service;

    @GetMapping("/1")
    @ResponseBody
    public User t1() {
        User user = new User();
        user.setId(999);
        user.setName("2b");
        api1Service.addUser(user);
        User res = api1Service.getUser(user.getId());
        return res;
    }

    @GetMapping("/2")
    @ResponseBody
    public Phone t2() {
        Phone phone = new Phone();
        phone.setNumber("2345");
        System.out.println(api2Service.addPhone(phone));
        Phone res = api2Service.getPhone();
        return phone;

    }

    @PostMapping("/api1/user/{path}")
    @ResponseBody
    public Object t3(@PathVariable String path, @RequestBody Object object) {
        Object res = api1Service.anyPost(path, object);
        return res;
    }
//    curl  -s http://localhost:10013/api1/user/add -X POST -H "Content-Type:application/json;charset=utf-8" -d '{"id":1,"name":"2"}'

}
