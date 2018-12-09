package com.mhc.springboot_threadpool.tasks;

import com.mhc.springboot_threadpool.threadpool.PoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Task1 implements ITask {

    private static Logger logger = LoggerFactory.getLogger(Task1.class);

    String id;

    @Override
    public String getData() {
        return "task1(id="+ this.id+ ")";
    }

    public Task1(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        logger.info("task1(id={}) start------------------", this.id);
        try {
            for(int i=0; i<60; i++) {
                logger.info("task1(id={}) running-------", this.id);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            logger.warn("exit by interrupt");
        }
        PoolService.getCacheMap().remove(this.id);
        logger.info("task1(id={}) done--------: ", this.id);
    }
}
