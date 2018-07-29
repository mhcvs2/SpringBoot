package com.mhc.testtemplate.task

interface Task {

    String getId()

    List<Object> getResultObject()

    void addResultObjects(List<Object> results)

    List<? extends Status> getHistory()

    void updateStatus(String phase, String status)

    void complete()

    void fail()

    Status getStatus()

    long getStartTimeMs()
}