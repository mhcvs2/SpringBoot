package com.mhc.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -4083327605430665846L;

    public final static String CONTEXT_KEY_USERiD = "x-customs-user";

    private String userId;
    private String userName;

    public User(Map<String, String> headers) {
        userId = headers.get(CONTEXT_KEY_USERiD);
    }

    public Map<String, String> toHttpHeaders(){
        Map<String, String> headers = new HashMap<>();
        headers.put(CONTEXT_KEY_USERiD, userId);
        return headers;
    }
}
