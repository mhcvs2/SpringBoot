package com.mhc.prometheus_test2;

import io.micrometer.core.instrument.*;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


class Resource extends Number {
    private Double value;

    public double get(){
        return this.value;
    }

    public void set(Double value){
        this.value = value;
    }

    public Resource() {
        super();
    }

    @Override
    public byte byteValue() {
        return super.byteValue();
    }

    @Override
    public short shortValue() {
        return super.shortValue();
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return this.value;
    }
}

@Component
public class Tasks {

    List<Tag> init(){
        ArrayList<Tag> tags = new ArrayList(){};
        tags.add(new ImmutableTag("region", "shanghai"));
        tags.add(new ImmutableTag("user", "mhc"));
        tags.add(new ImmutableTag("product", "kdc"));
        tags.add(new ImmutableTag("group", "group1"));
        return tags;
    }

    private static Random random = new Random();
    private static Resource resource = new Resource();
    private static MeterRegistry registry = new SimpleMeterRegistry();
    Gauge passCaseGuage = Gauge.builder("inprogress_requests", resource, Resource::get)
            .tags("region", "user", "product", "group")
            .description("pass cases guage of demo")
            .register(registry);

    Resource passCases =  Metrics.gauge("inprogress_requests", init(), resource);


    @Scheduled(fixedRate=5000)
    public void gatherResource(){
        System.out.println("gatherResource=========");
        passCases.set(random.nextDouble());
        System.out.println(passCases.get());

    }

}
