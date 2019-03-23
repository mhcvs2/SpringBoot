package com.mhc.configuration_test.configurationProperties.c;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "mail")
public class MailProperties3 {

    private String host;
    private int port;
    private Smtp smtp;

    @Data
    public static class Smtp {
        private boolean auth;
    }

}
