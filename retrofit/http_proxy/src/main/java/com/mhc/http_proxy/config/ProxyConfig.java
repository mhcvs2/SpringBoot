package com.mhc.http_proxy.config;

import com.google.common.collect.ImmutableMap;
import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import java.util.Map;

@Configuration
public class ProxyConfig {

    @Bean
    public Servlet baiduProxyServlet(){
        return new ProxyServlet();
    }

    @Bean
    public ServletRegistrationBean proxyServletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(baiduProxyServlet(), "/api1/*");
        Map<String, String> params = ImmutableMap.of(
                "targetUri", "http://localhost:10011",
                "log", "true");
        registrationBean.setInitParameters(params);
        return registrationBean;
    }
//    curl -s http://localhost:10014/api1/user/1


}
