package com.wisely.ch8_5.controller;

import com.wisely.ch8_5.Service.DemoService;
import com.wisely.ch8_5.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/put")
    public Person put(Person person){
        return demoService.save(person);
    }

    @RequestMapping("/able")
    public Person cacheable(Person person){
        return demoService.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id) {
        try{
            demoService.remove(id);
        } catch (Exception e) {
            return e.toString();
        }

        return "ok";
    }


}
