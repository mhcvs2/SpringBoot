package com.mhc.testtemplate.task

enum TaskState {

    STARTED,
    COMPLETED,
    FAILED

    boolean isCompleted() {
        this != STARTED
    }

    boolean isFailed() {
        this == FAILED
    }

}
