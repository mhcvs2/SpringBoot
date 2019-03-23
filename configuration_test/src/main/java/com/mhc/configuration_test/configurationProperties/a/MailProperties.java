package com.mhc.configuration_test.configurationProperties.a;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "mail")
@Data
@Component
public class MailProperties {

    private String host;
    private int port;
    private Smtp smtp;

    @Data
    public static class Smtp {
        private boolean auth;
    }

}
