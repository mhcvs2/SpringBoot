package com.wisely.highlight_spring4.ch3.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void t1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);

        for(int i=0; i<10; i++){
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();
    }

    public static void t2() throws InterruptedException, ExecutionException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
        Future<String> future = asyncTaskService.executeAsyncWithReturn();
        while (true) {
            if(future.isDone()) {
                System.out.println("result is: " + future.get());
                break;
            }
            System.out.println("continue doing something else.");
            Thread.sleep(1000);
        }
    }

    public static void t3() throws InterruptedException, ExecutionException, TimeoutException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
        Future<String> future1 = asyncTaskService.executeAsyncWithReturn();
        Future<String> future2 = asyncTaskService.executeAsyncWithReturn();
        List<Future<String>> futures = new ArrayList<>();
        futures.add(future1);
        futures.add(future2);
        List<String> res = AsyncUtil.waitResult(futures, 500, 30);
        res.forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        t3();
    }
}
