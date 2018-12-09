package com.mhc.springboot_threadpool.service;

import com.mhc.springboot_threadpool.exceptions.MhcException1;
import com.mhc.springboot_threadpool.tasks.Task1;
import com.mhc.springboot_threadpool.threadpool.PoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AsyncTaskService {

    private static Logger logger = LoggerFactory.getLogger(AsyncTaskService.class);

    @Async
    public void executeAsyncTask1(Integer id){
        logger.info("task1(id={}) start------------------", id);
        try {
            for(int i=0; i<60; i++) {
                logger.info("task1(id={}) running-------", id);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            logger.warn("exit by interrupt");
        }
        logger.info("task1(id={}) done--------: ", id);
    }

    @Async
    @Retryable(value = {MhcException1.class}, maxAttempts = 5, backoff = @Backoff(value = 500L))
    public void executeAsyncTaskPlus(Integer i) throws MhcException1 {
        System.out.println("执行异步任务+1: "+(i+1));
        throw new MhcException1("1111");
    }
}
