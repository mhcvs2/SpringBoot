package com.mhc.m1;

import com.alibaba.fastjson.JSON;
import com.mhc.m1.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class M1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(M1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setId(1);
        user.setName("ha");
        System.out.println(JSON.toJSONString(user));
    }
}
