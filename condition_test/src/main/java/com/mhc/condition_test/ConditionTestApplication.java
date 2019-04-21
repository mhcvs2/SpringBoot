package com.mhc.condition_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConditionTestApplication implements CommandLineRunner {

    @Autowired
    ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(ConditionTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("====================================================");
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            if(name.startsWith("test"))  System.out.println(name);
        }

        System.out.println("====================================================");
    }
}
