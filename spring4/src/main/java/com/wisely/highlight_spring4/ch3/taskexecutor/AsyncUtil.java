package com.wisely.highlight_spring4.ch3.taskexecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncUtil {

    public static <T> List<T> waitResult(List<Future<T>> futures, int interval, long timeout) throws ExecutionException, InterruptedException, TimeoutException {
        long start = System.currentTimeMillis();
        long end = start + timeout * 1000;
        boolean allDone;
        while (System.currentTimeMillis() < end) {
            allDone = futures.stream().allMatch(Future::isDone);
            if(allDone) {
                List<T> res = new ArrayList<>();
                for(Future<T> tFuture: futures) {
                    res.add(tFuture.get());
                }
                return res;
            } else {
                TimeUnit.MILLISECONDS.sleep(interval);
            }
        }
        throw new TimeoutException("wait result time out");
    }

}
