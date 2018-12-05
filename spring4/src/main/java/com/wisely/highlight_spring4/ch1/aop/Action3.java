package com.wisely.highlight_spring4.ch1.aop;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action3 {
    String value();
    int lockTime() default 15;
}
