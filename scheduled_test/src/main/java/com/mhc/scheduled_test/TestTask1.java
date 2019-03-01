package com.mhc.scheduled_test;

public class TestTask1 implements Runnable {

    private String name;

    public TestTask1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("task name: " + name);
    }
}
