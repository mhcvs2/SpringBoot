package com.mhc.api2.controller;

import com.mhc.api2.model.Phone;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    @PostMapping
    public String add(@RequestBody Phone phone) {
        System.out.println("add phone, number " + phone.getNumber());
        return "success";
    }

    @GetMapping
    @ResponseBody
    public Phone get(){
        Phone res = new Phone();
        res.setNumber("123456");
        return res;
    }

}
