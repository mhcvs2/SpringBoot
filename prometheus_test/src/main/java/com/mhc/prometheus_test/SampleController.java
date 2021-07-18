package com.mhc.prometheus_test;

import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SampleController {

    private static Random random = new Random();

    private static final Counter requestTotal = Counter.build().name("my_sample_counter") .labelNames("status") .help("A simple Counter to illustrate custom Counters in Spring Boot and Prometheus").register();

    private static final Gauge inprogressRequests = Gauge.build()
            .name("inprogress_requests").help("test")
            .labelNames("region", "user", "product", "group")
            .register();

    @RequestMapping("/endpoint")
    public void endpoint() {
        System.out.println("endpoint===========================");
        if (random.nextInt(2) > 0) {
            requestTotal.labels("success").inc();
        } else {
            requestTotal.labels("error").inc();
        }
    }

    @Scheduled(fixedRate=5000)
    public void gatherResource(){
        System.out.println("gatherResource=========");
//        inprogressRequests.labels("shanghai", "mhc", "kdc", "group1").set(random.nextDouble());
        inprogressRequests.labels("shanghai", "mhc", "kdc", "group1").set(0);
        inprogressRequests.labels("shanghai", "mhc", "kdc", "group1").inc();
    }


}
