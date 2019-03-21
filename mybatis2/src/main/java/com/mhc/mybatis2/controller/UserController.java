package com.mhc.mybatis2.controller;

import com.mhc.mybatis2.model.User;
import com.mhc.mybatis2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.stream.Stream;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public int add(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/add2")
    public int add2(@RequestBody  User user){
        return userService.addUser2(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/1")
    public void test1(HttpServletRequest request) {
        System.out.println("getRemoteUser(): " + request.getRemoteUser());
        System.out.println("getRemoteAddr(): " + request.getRemoteAddr());
        System.out.println("getRemoteHost(): " + request.getRemoteHost());
        System.out.println("getLocalAddr(): " + request.getLocalAddr());
        System.out.println("getRequestURL(): " + request.getRequestURL());
        System.out.println("getRequestURI(): " + request.getRequestURI());
        System.out.println("getPathInfo(): " + request.getPathInfo());
        System.out.println("getQueryString(): " + request.getQueryString());
        System.out.println("getParameterMap(): ");
        request.getParameterMap().forEach((k, v) -> {
            System.out.println(k + "=" + Arrays.toString(v));
        });
    }
    /*
    *  curl -X GET "http://192.168.139.36:8080/user/1?name=dfds&aa=222"
    *  getRemoteUser(): null
getRemoteAddr(): 192.168.139.36
getRemoteHost(): 192.168.139.36
getLocalAddr(): 192.168.139.36
getRequestURL(): http://192.168.139.36:8080/user/1
getRequestURI(): /user/1
getPathInfo(): null
getQueryString(): name=dfds&aa=222
getParameterMap():
name=[dfds]
aa=[222]
    * */

    @PostMapping("/2")
    public void test2(HttpServletRequest request, @RequestBody User user) {
        System.out.println("--------------------------");
        System.out.println(user.getUserName());
        System.out.println("getRemoteUser(): " + request.getRemoteUser());
        System.out.println("getRemoteAddr(): " + request.getRemoteAddr());
        System.out.println("getRemoteHost(): " + request.getRemoteHost());
        System.out.println("getLocalAddr(): " + request.getLocalAddr());
        System.out.println("getRequestURL(): " + request.getRequestURL());
        System.out.println("getRequestURI(): " + request.getRequestURI());
        System.out.println("getServletPath(): " + request.getServletPath());
        System.out.println("getPathInfo(): " + request.getPathInfo());
        System.out.println("getQueryString(): " + request.getQueryString());
        System.out.println("getParameterMap(): ");
        request.getParameterMap().forEach((k, v) -> {
            System.out.println(k + "=" + Arrays.toString(v));
        });
    }
    /*
curl -X POST -H "Content-Type:application/json;charset=utf-8" "http://192.168.139.36:8080/user/2" -d '{"userName":"mhc", "password":"123"}'

mhc
getRemoteUser(): null
getRemoteAddr(): 192.168.139.36
getRemoteHost(): 192.168.139.36
getLocalAddr(): 192.168.139.36
getRequestURL(): http://192.168.139.36:8080/user/2
getRequestURI(): /user/2
getServletPath(): /user/2
getPathInfo(): null
getQueryString(): null
getParameterMap():
    * */

}
