package com.wisely.highlight_spring4.ch1.aop;

public class SomeThing {

    @Action2(value="t1")
    public void doSomeThing() {
        System.out.println("doSomeThing---------------");
    }

}
