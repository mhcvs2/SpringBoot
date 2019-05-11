package com.mhc.prometheus_test2;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Metrics;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("CollectorService")
public class CollectorService {

    static final Counter userCounter = Metrics.
            counter("user.counter.total", "services", "demo");
    public void processCollectResult() throws InterruptedException {

        while (true){
            TimeUnit.SECONDS.sleep(1);
            userCounter.increment(1D);

        }

    }

}
