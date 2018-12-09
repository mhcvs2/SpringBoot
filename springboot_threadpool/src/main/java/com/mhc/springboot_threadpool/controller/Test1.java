package com.mhc.springboot_threadpool.controller;

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

    @GetMapping("/1")
    public String t1(@RequestParam(name = "task_id", required = true, defaultValue = "default") String taskId){
        poolService.addTask(taskId);
        return "success";
    }

}
