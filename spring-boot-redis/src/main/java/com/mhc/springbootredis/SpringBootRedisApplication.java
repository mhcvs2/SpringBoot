package com.mhc.springbootredis;

import com.mhc.springbootredis.common.lock.DistributedLockerUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class SpringBootRedisApplication {

    private static final String key = "a:b:c:7";

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisApplication.class, args);
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void t1(){
        System.out.println("t1================");
        System.out.println(LocalDateTime.now().toLocalTime());
        System.out.println(Thread.currentThread().getId());
        System.out.println(DistributedLockerUtil.tryLock(key));
        System.out.println("t1================end");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void t2(){
        System.out.println("t2================");
        System.out.println(LocalDateTime.now().toLocalTime());
        System.out.println(Thread.currentThread().getId());
        System.out.println(DistributedLockerUtil.tryLock(key));
        System.out.println("t2================end");
    }
}
