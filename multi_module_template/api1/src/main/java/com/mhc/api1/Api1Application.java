package com.mhc.api1;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Api1Application {

    public static void main(String[] args) {
        System.out.println(RandomUtils.nextInt(0, 100));
        SpringApplication.run(Api1Application.class, args);
    }
}
