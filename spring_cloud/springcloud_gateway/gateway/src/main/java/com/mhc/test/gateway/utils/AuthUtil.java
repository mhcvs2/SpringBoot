package com.mhc.test.gateway.utils;

import java.util.HashMap;
import java.util.Map;

public class AuthUtil {

    private static Map<String, String> map = new HashMap<>();

    public AuthUtil() {
    }

    public static void init(){
        map.put("tom", "123456");
    }

    public static boolean isPermitted(String name, String password) {
        return map.containsKey(name) && map.get(name).equals(password);
    }
}
