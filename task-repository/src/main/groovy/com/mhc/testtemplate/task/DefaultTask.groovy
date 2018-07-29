package com.mhc.testtemplate.task

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.CompileStatic
import groovy.transform.Immutable

import java.util.concurrent.ConcurrentLinkedDeque
import java.util.logging.Logger

@CompileStatic
public class DefaultTask implements Task {

    private static final Logger log = Logger.getLogger(DefaultTask.name)

    final String id
    private final Deque<Status> statusHistory = new ConcurrentLinkedDeque<Status>()
    private final Deque<Object> resultObjects = new ConcurrentLinkedDeque<Object>()
    final long startTimeMs = System.currentTimeMillis()

    DefaultTask(String id) {
        this(id, "INIT", "Creating task ${id}")
    }

    DefaultTask(String id, String phase, String status){
        def initialStatus = new DefaultTaskStatus(phase, status, TaskState.STARTED)
        statusHistory.addLast(initialStatus)
        this.id = id
    }

    @Override
    List<Object> getResultObject() {
        resultObjects.collect()
    }

    @Override
    void addResultObjects(List<Object> results) {
        if (results) {
            currentStatus().ensureUpdateable()
            resultObjects.addAll(results)
        }
    }

    @Override
    List<? extends Status> getHistory() {
        statusHistory.collect {
            new TaskDisplayStatus(it)
        }
    }

    @Override
    void updateStatus(String phase, String status) {
        println("updateStatus==================")
        statusHistory.addLast(currentStatus().update(phase, status))
        log.info "[$phase] - $status"
    }

    @Override
    void complete() {
        statusHistory.addLast(currentStatus().update(TaskState.COMPLETED))
    }

    @Override
    void fail() {
        statusHistory.addLast(currentStatus().update(TaskState.FAILED))
    }

    @Override
    Status getStatus() {
        currentStatus()
    }

    private DefaultTaskStatus currentStatus() {
        statusHistory.getLast() as DefaultTaskStatus
    }
}

@Immutable
@CompileStatic
class DefaultTaskStatus implements Status {

    String phase
    String status

    @JsonIgnore
    TaskState state

    static DefaultTaskStatus create(String phase, String status, TaskState state) {
        new DefaultTaskStatus(phase, status, state)
    }

    @Override
    Boolean isCompleted() {
        return state.completed
    }

    @Override
    Boolean isFailed() {
        return state.failed
    }

    DefaultTaskStatus update(String phase, String status) {
        ensureUpdateable()
        new DefaultTaskStatus(phase, status, state)
    }

    DefaultTaskStatus update(TaskState state) {
        ensureUpdateable()
        new DefaultTaskStatus(phase, status, state)
    }

    void ensureUpdateable() {
        if(isCompleted()) {
            throw new IllegalStateException("Task is already completed: No further updates allowed!")
        }
    }

    @Override
    String getStateString() {
        state.toString()
    }
}

@Immutable(knownImmutableClasses = [Status])
@CompileStatic
class TaskDisplayStatus implements Status {

    @JsonIgnore
    Status taskStatus

    static TaskDisplayStatus create(Status taskStatus) {
        new TaskDisplayStatus(taskStatus)
    }

    @Override
    String getPhase() {
        taskStatus.phase
    }

    @Override
    String getStatus() {
        taskStatus.status
    }

    @Override
    String getStateString() {
        taskStatus.getStateString()
    }

    @Override
    @JsonIgnore
    Boolean isCompleted() {
        taskStatus.isCompleted()
    }

    @Override
    @JsonIgnore
    Boolean isFailed() {
        taskStatus.isFailed()
    }
}
