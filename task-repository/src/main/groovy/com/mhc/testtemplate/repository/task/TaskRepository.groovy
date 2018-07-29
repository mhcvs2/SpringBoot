package com.mhc.testtemplate.repository.task

import com.mhc.testtemplate.task.Task

interface TaskRepository {

    static final ThreadLocal<Task> threadLocalTask = new ThreadLocal<>()

    Task create(String phase, String status)

    Task create(String phase, String status, String clientRequestId)

    Task get(String id)

    Task getByClientRequestId(String clientRequestId)

    List<Task> list()

}