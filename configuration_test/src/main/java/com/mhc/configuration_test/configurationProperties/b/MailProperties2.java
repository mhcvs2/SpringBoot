package com.mhc.configuration_test.configurationProperties.b;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
public class MailProperties2 {

    private String host;
    private int port;
    private Smtp smtp;

    @Data
    public static class Smtp {
        private boolean auth;
    }

}
