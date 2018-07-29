package com.mhc.testtemplate.repository.task

import com.mhc.testtemplate.task.DefaultTask
import com.mhc.testtemplate.task.Task

import java.util.concurrent.ConcurrentHashMap

class InMemoryTaskRepository implements TaskRepository {

    private final Map<String, Task> repository = new ConcurrentHashMap<>()
    private final Map<String, Task> clientRequestRepository = new ConcurrentHashMap<>()

    @Override
    Task create(String phase, String status, String clientRequestId) {
        if(clientRequestRepository.containsKey(clientRequestId)) {
            return clientRequestRepository.get(clientRequestId)
        }
        def task = new DefaultTask(nextId, phase, status)
        repository[task.id] = task
        clientRequestRepository[clientRequestId] = task
    }

    @Override
    Task create(String phase, String status) {
        create(phase, status, UUID.randomUUID().toString())
    }

    @Override
    Task get(String id) {
        repository?.get(id)
    }

    @Override
    Task getByClientRequestId(String clientRequestId) {
        clientRequestRepository[clientRequestId]
    }

    @Override
    List<Task> list() {
        repository.values() as List
    }

    private String getNextId() {
        while (true) {
            def maybeNext = new BigInteger(new Random().nextInt(Integer.MAX_VALUE)).toString(36)
            if(!repository.containsKey(maybeNext)) {
                return maybeNext
            }
        }
    }
}
