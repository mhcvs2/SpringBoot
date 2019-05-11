package com.mhc.prometheus_test;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnablePrometheusEndpoint
@EnableScheduling
//@EnableSpringBootMetricsCollector   // 收集spring boot 本身的metrics
public class PrometheusTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrometheusTestApplication.class, args);
    }

}
