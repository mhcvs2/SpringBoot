package com.mhc.test.hystrix.service1.service;

import com.mhc.test.hystrix.common.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addUserFail")
    public String addUser(User user){
        String url = "http://localhost:8080/test/t1";
        return restTemplate.postForObject(url, user, String.class);
    }

    @HystrixCommand(fallbackMethod = "getUserFail")
    public User getUser(Integer id) {
        return restTemplate.getForObject("http://localhost:8080/test/t1/{1}", User.class, id);
    }

    private String addUserFail(User user){
        return "add user fail";
    }

    private User getUserFail(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("unknow");
        return user;
    }

}
