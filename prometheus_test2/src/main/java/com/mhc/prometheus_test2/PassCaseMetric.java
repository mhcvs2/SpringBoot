package com.mhc.prometheus_test2;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.ImmutableTag;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component("passCaseMetric")
public class PassCaseMetric {

    List<Tag> init(){
        ArrayList<Tag> list = new ArrayList(){};
        list.add(new ImmutableTag("service", "demo"));
        return list;
    }

    AtomicInteger atomicInteger = new AtomicInteger(0);

    Gauge passCaseGuage = Gauge.builder("pass.cases.guage", atomicInteger, AtomicInteger::get)
            .tag("service", "demo")
            .description("pass cases guage of demo")
            .register(new SimpleMeterRegistry());


    AtomicInteger passCases =  Metrics.gauge("pass.cases.guage.value", init(), atomicInteger);

    public void handleMetrics() {

        while (true){
            if (System.currentTimeMillis() % 2 == 0){
                passCases.addAndGet(100);
                System.out.println("ADD + " + passCaseGuage.measure() + " : " + passCases);
            }else {
                int val = passCases.addAndGet(-100);
                if (val < 0){
                    passCases.set(1);
                }
                System.out.println("DECR - " + passCaseGuage.measure() + " : " + passCases);
            }
        }

    }

}

