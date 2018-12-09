package com.wisely.highlight_spring4.ch1.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void t1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);

        demoAnnotationService.add();
        demoMethodService.add();
        context.close();
    }
    //        add in DemoAnnotationService
//        注解式拦截 注解式拦截的add操作
//        方法规则式拦截,add
//        add in DemoMethodService

    public static void t2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        demoAnnotationService.t1("haa", 222);
    }

    public static void t3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        Book book = new Book(1, "mhc");
        demoAnnotationService.t3(book);
    }

    public static void main(String[] args){
        t3();
    }
}