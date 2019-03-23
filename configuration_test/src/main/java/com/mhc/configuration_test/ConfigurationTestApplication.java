package com.mhc.configuration_test;

import com.mhc.configuration_test.configurationProperties.a.MailProperties;
import com.mhc.configuration_test.configurationProperties.b.MailProperties2;
import com.mhc.configuration_test.configurationProperties.c.MailProperties3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigurationTestApplication implements CommandLineRunner {

    @Autowired
    MailProperties mailProperties;

    @Autowired
    MailProperties2 mailProperties2;

    @Autowired
    MailProperties3 mailProperties3;

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationTestApplication.class, args);
    }

    public void t1(){
        System.out.println(mailProperties.toString());
    }

    public void t2(){
        System.out.println(mailProperties2.toString());
    }

    public void t3(){
        System.out.println(mailProperties3.toString());
    }

    @Override
    public void run(String... args) throws Exception {
        t3();
    }
}
