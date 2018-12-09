package com.mhc.springboot_retry;

import com.mhc.springboot_retry.exceptions.MhcException1;
import com.mhc.springboot_retry.exceptions.MhcException2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/1")
    public void t1() throws MhcException1{
        throw new MhcException1("mhcsdfsadf", "haha");
    }

    @GetMapping("/2/{id}")
    public void t2(@PathVariable int id) {
        try {
            testService.test1(id);
        } catch (MhcException1 exception1) {
            System.out.println(exception1);
        }
    }
// 加recover之前：
//    test1 get -111
//    test1 get -111
//    test1 get -111
//    test1 get -111
//    test1 get -111
//    com.mhc.springboot_retry.exceptions.MhcException1: fu de

    // 加了recover之后：
//    test1 get -111
//    test1 get -111
//    test1 get -111
//    test1 get -111
//    test1 get -111
//    recovercom.mhc.springboot_retry.exceptions.MhcException1: fu de

    @GetMapping("/3/{id}")
    public void t3(@PathVariable int id) {
        testService.test2(id);
    }

    @GetMapping("/4/{id}")
    public void t4(@PathVariable int id) {
        try {
            testService.test3(id);
        } catch (MhcException1 exception1) {
            System.out.println(exception1);
        }
    }

}
