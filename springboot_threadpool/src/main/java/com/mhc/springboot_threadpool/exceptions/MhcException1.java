package com.mhc.springboot_threadpool.exceptions;

public class MhcException1 extends Exception {

    public MhcException1(String message) {
        super(message);
    }

    public MhcException1(String message, String name) {
        super(message + ", name is " + name);
    }

}
