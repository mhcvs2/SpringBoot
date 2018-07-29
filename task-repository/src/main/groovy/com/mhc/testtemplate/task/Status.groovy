package com.mhc.testtemplate.task

interface Status {

    String getPhase()

    String getStatus()

    Boolean isCompleted()

    Boolean isFailed()

    String getStateString()

}