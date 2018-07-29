package com.mhc.testtemplate.controller

import com.mhc.testtemplate.exceptions.ServiceNotFoundException
import com.mhc.testtemplate.repository.task.TaskRepository
import com.mhc.testtemplate.service.Service
import com.mhc.testtemplate.task.Task
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/test")
class TestController {

    static final TASK_PHASE = "controller"

    @Autowired
    TaskRepository taskRepository

    @Autowired
    List<Service> services

    @RequestMapping(value = "/{name:.+}", method = RequestMethod.GET)
    String tc1(@PathVariable String name) {
        Task task = taskRepository.create(TASK_PHASE, "Initializing test task ${name}...")
        try {
            List<Service> serviceImpls = services.findAll {
                it.handles(name)
            }
            if(serviceImpls.size() == 0) {
                throw new ServiceNotFoundException("No service can handle ${name}, taskId: ${task.id}")
            } else if(serviceImpls.size() > 1) {
                def namesString = serviceImpls.collect { it.getClass().simpleName }.join(", ")
                throw new RuntimeException("Multiple services can handle ${name}, they are ${namesString}, taskId: ${task.id}")
            }
            serviceImpls.first().doSomething()
        } catch (e) {
            def message = e.message
            def stringWriter = new StringWriter()
            def printWriter = new PrintWriter(stringWriter)
            e.printStackTrace(printWriter)
            def stackTrace = stringWriter.toString()
            if(!message) {
                message = stackTrace
            }
            task.updateStatus TASK_PHASE, "test task failed"
            task.addResultObjects([[type: "EXCEPTION", cause: e.class.simpleName, message: message]])
            task.fail()
//            println(stackTrace)
        } finally {
            if (!task.status?.isCompleted()) {
                task.complete()
            }
        }
        "task id: ${task.id}"
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    Task get(@PathVariable("id") String id) {
        Task t = taskRepository.get(id)
        if(!t) {
            throw new RuntimeException("Task not found (id: ${id})")
        }
        return t
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Task> list() {
        taskRepository.list()
    }

}
