package com.mhc.springboot_threadpool.controller;

import com.mhc.springboot_threadpool.exceptions.MhcException1;
import com.mhc.springboot_threadpool.service.AsyncTaskService;
import com.mhc.springboot_threadpool.threadpool.PoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/t1")
public class Test1 {

    @Autowired
    PoolService poolService;

    @Autowired
    AsyncTaskService asyncTaskService;

    @GetMapping("/1")
    public String t1(@RequestParam(name = "task_id", required = true, defaultValue = "default") String taskId){
        poolService.addTask(taskId);
        return "success";
    }

    @GetMapping("/2")
    public String t2(@RequestParam(name = "task_id", required = true, defaultValue = "default") String taskId){
        poolService.addTask2(taskId);
        return "success";
    }

    @GetMapping("/3")
    public String t3(){
        asyncTaskService.executeAsyncTask1(123);
        return "success";
    }

    @GetMapping("/4")
    public String t4(){
        try {
            asyncTaskService.executeAsyncTaskPlus(123);
        } catch (MhcException1 exception1){
            exception1.printStackTrace();
        }

        return "success";
    }

}
