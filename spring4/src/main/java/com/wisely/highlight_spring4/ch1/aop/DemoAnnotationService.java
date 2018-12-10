package com.wisely.highlight_spring4.ch1.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
    @Action(name="注解式拦截的add操作")
    public void add(){
        System.out.println("add in DemoAnnotationService");
    }

    @Action2(value="t1")
    public String t1(String a, int b) {
        System.out.println(a);
        return a + Integer.toString(b);
    }

    @Action3(value = "#book.name + '-' + #book.id")
    public void t3(Book book){
        System.out.println(book.name);
    }

    public void t4(){
        SomeThing someThing = new SomeThing();
        someThing.doSomeThing();
    }
}
