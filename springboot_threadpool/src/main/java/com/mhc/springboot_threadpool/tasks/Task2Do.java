package com.mhc.springboot_threadpool.tasks;

import com.mhc.springboot_threadpool.exceptions.MhcException1;
import com.mhc.springboot_threadpool.threadpool.PoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import java.util.concurrent.TimeUnit;

public class Task2Do {

    private static Logger logger = LoggerFactory.getLogger(Task2.class);

    private String id;

    public Task2Do(String id) {
        this.id = id;
    }

    @Retryable(value = {MhcException1.class}, maxAttempts = 5, backoff = @Backoff(value = 500L))
    public void execute() throws MhcException1 {
        logger.info("task1(id={}) start------------------", this.id);
        try {
            for(int i=0; i<60; i++) {
                logger.info("task1(id={}) running-------", this.id);
                TimeUnit.SECONDS.sleep(1);
                throw new MhcException1("sdfsdf");
            }
        } catch (InterruptedException e) {
            logger.warn("exit by interrupt");
        }
        PoolService.getCacheMap().remove(this.id);
        logger.info("task1(id={}) done--------: ", this.id);
    }
}
