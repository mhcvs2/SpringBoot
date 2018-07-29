package com.mhc.testtemplate.service

import com.mhc.testtemplate.repository.task.TaskRepository
import com.mhc.testtemplate.task.Task

@org.springframework.stereotype.Service
class MyService implements Service {

    private static Task getTask() {
        TaskRepository.threadLocalTask.get()
    }

    @Override
    void doSomething() {
        task.updateStatus "MyService doSomething", "Start doSomething"
        task.updateStatus "MyService doSomething", "doSomething Done"
    }

    @Override
    boolean handles(String name) {
        name == "mhc"
    }
}
