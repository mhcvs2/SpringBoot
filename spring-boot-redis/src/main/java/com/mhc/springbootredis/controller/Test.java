package com.mhc.springbootredis.controller;

import com.mhc.springbootredis.common.lock.RedissLockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
public class Test {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @GetMapping("/1")
    public void t1(){
        redisTemplate.opsForValue().set("k1", "v1");
        String res = redisTemplate.opsForValue().get("k1");
        System.out.println(res);
    }

    @GetMapping("/2")
    public void t2() throws InterruptedException{
        redisTemplate.opsForValue().set("tmpkey", "tmpvalue", 10, TimeUnit.SECONDS);
        String res = "some";
        while (res != null && !res.equals("")) {
            res = redisTemplate.opsForValue().get("tmpkey");
            TimeUnit.SECONDS.sleep(1L);
            System.out.println("next");
        }
        System.out.println("end");
    }

    @GetMapping("/3")
    public void t3(){
        if(RedissLockUtil.tryLock("haha", 30, 10)){
            System.out.println("lock success");
        }
        System.out.println("end");
    }

}
