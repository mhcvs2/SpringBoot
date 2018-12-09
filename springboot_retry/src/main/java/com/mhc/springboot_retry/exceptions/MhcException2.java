package com.mhc.springboot_retry.exceptions;

public class MhcException2 extends Exception {

    public MhcException2(String message) {
        super(message);
    }

    public MhcException2(String message, String name) {
        super(message + ", name is " + name);
    }

}
