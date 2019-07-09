package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;

import java.text.MessageFormat;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MediaType json  = MediaType.valueOf("application/json;charset=UTF-8");
        MediaType json2 = MediaType.APPLICATION_JSON_UTF8;
//        MediaType json  = MediaType.valueOf("text/plain");
        // "text/plain"
        System.out.println(json.toString());
        System.out.println(json.getType());
        System.out.println(json2.toString());
        System.out.println(json2.getType());
    }
}

