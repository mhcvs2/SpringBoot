package com.mhc.springbootredis.controller;

import com.mhc.springbootredis.common.lock.DistributedLockerUtil;
import com.mhc.springbootredis.common.lock.redisson.RedissonUtil;
import io.lettuce.core.dynamic.annotation.Param;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        if(RedissonUtil.tryLockByTimeout("haha", 30)){
            System.out.println("lock success");
        }
        System.out.println("end");
    }

    @GetMapping("/4/{id}")
    public void t4(@PathVariable int id) throws InterruptedException{
        String key = "a:b:c";
        RLock lock = RedissonUtil.lockByTimeout(key);
        try {
            System.out.println("do something: id " + id);
            TimeUnit.SECONDS.sleep(5);
            System.out.println("done");
        }  finally {
            lock.unlock();
        }
        System.out.println("end");
    }

    @GetMapping("/5/{id}")
    public void t5(@PathVariable int id) throws InterruptedException{
        String key = "a:b:c";
        RLock lock = DistributedLockerUtil.lockByTimeout(key);
        try {
            System.out.println("do something: id " + id);
            TimeUnit.SECONDS.sleep(5);
            System.out.println("done");
        }  finally {
            lock.unlock();
        }
        System.out.println("end");
    }

    @GetMapping("/6")
    public boolean t6() {
        String key = "a:b:c:6";
        for (int i = 0; i < 5; i++) {
            System.out.println(DistributedLockerUtil.tryLock(key));
        }
        return false;
    }

}
