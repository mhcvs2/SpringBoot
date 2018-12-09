package com.mhc.springboot_threadpool.threadpool;

import com.mhc.springboot_threadpool.tasks.ITask;
import com.mhc.springboot_threadpool.tasks.Task1;
import com.mhc.springboot_threadpool.tasks.Task2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.*;

@Component
public class PoolService {

    private static Logger logger = LoggerFactory.getLogger(PoolService.class);

    /**
     * 线程池维护线程的最少数量
     */
    private final static int CORE_POOL_SIZE = 2;

    /**
     * 线程池维护线程的最大数量
     */
    private final static int MAX_POOL_SIZE = 3;

    /**
     * 线程池维护线程所允许的空闲时间
     */
    private final static int KEEP_ALIVE_TIME = 60;

    /**
     * 线程池所使用的缓冲队列大小
     */
    private final static int WORK_QUEUE_SIZE = 5;

    /**
     * 用于储存在队列中的任务 ,防止重复提交
     */
    private final static Map<String, Object> cacheMap = new ConcurrentHashMap<>();


    /**
     * 当线程池的容量满，记录error log
     */
    private final static RejectedExecutionHandler handler = new RejectedExecutionHandler() {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            logger.warn("线程池容量已满， 任务被拒绝处理 ：", ((ITask) r).getData());
        }
    };

    public static Map getCacheMap() {
        return cacheMap;
    }

    /**
     * 创建线程池
     */
    private final static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE,
            MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(WORK_QUEUE_SIZE), handler);

    public void addTask(String taskId) {
        if(cacheMap.get(taskId) == null ) {
            cacheMap.put(taskId, taskId);
            Task1 task1 = new Task1(taskId);
            threadPool.execute(task1);
        }
    }

    public void addTask2(String taskId) {
        if(cacheMap.get(taskId) == null ) {
            cacheMap.put(taskId, taskId);
            Task2 task2 = new Task2(taskId);
            threadPool.execute(task2);
        }
    }

}
