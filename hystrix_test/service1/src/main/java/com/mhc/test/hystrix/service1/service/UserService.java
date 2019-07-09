package com.mhc.test.hystrix.service1.service;

import com.mhc.test.hystrix.common.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.exception.HystrixBadRequestException;
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

    private User getUser3(Integer id) {
        User user = null;
        try {
            user = restTemplate.getForObject("http://localhost:8080/test/t1/{1}", User.class, id);
        } catch (Exception e){
            return null;
        }
        return user;
    }

    @HystrixCommand(fallbackMethod = "getUserFail",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "10"),
                    @HystrixProperty(name = "maxQueueSize", value = "100"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "20")},
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
            })
    public User getUser2(Integer id) {
        System.out.println("getUser2============================");
        User user = getUser3(id);
//        if(user == null) throw new HystrixBadRequestException("dsfsdf");
        check(user);
        return user;
    }

    public void check(User user){
        if(user == null) {
            throw new IllegalStateException("sdfsfd");
        }
    }

    private String addUserFail(User user){
        return "add user fail";
    }

    private User getUserFail(Integer id) {
        System.out.println("getUserFail==========================");
        User user = new User();
        user.setId(id);
        user.setName("unknow");
        return user;
    }

}
