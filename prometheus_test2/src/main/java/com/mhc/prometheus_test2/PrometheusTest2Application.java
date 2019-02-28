package com.mhc.prometheus_test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableScheduling
public class PrometheusTest2Application {

    @Autowired
    PassCaseMetric passCaseMetric;

    public static void main(String[] args) {
        SpringApplication.run(PrometheusTest2Application.class, args);
    }

    @GetMapping("test")
    public void test(){
        passCaseMetric.handleMetrics();
    }

}
