package com.mhc.kerberos_test.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 资源管理服务地址
 * create by liuzx on 2018/10/23
 **/
@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "kerberos")
public class KerberosConfig {

    @Getter
    @Setter
    public static class Prop{
        private String k;
        private String v;
    }

    private String realms = "TEST.COM";
    private String url;
    private String location = "/tmp";
    private String krb5;
    private String hdfsUrl;
    private String kdcServerName = "develop";
    private String tenant = "1";
    private String hadoopDir;
    private List<Prop> props;
    private String hadoopConfPath;
    private String keyPath;
    private String userMd5;
    private Boolean addUser = false;
    private String opUser;

}
