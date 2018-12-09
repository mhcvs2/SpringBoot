package com.mhc.springboot_threadpool.tasks;

import com.mhc.springboot_threadpool.exceptions.MhcException1;
import com.mhc.springboot_threadpool.threadpool.PoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Task2 implements ITask {

    private static Logger logger = LoggerFactory.getLogger(Task2.class);

    String id;

    @Override
    public String getData() {
        return "task1(id="+ this.id+ ")";
    }

    public Task2(String id) {
        this.id = id;
    }

    //retry 不好使
    @Override
    public void run() {
        try {
            Task2Do task2Do = new Task2Do(this.id);
            task2Do.execute();
        } catch (MhcException1 exception1) {
            exception1.printStackTrace();
        }

    }

}
