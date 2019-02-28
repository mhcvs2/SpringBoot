package com.mhc.scheduled_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class ScheduledTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledTestApplication.class, args);
    }

//    @Scheduled(cron = "0/5 * * * * ?")
//    public void t1(){
//        System.out.println("t1================");
//        System.out.println(LocalDateTime.now().toLocalTime());
//    }

}
