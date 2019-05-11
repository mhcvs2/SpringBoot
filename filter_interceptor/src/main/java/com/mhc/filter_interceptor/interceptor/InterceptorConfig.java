package com.mhc.filter_interceptor.interceptor;

import com.ksyun.auth.client.AuthenticationHelper;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


//WebMvcConfigurerAdapter 已经被弃用

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new FirstInterceptor());
//        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");;
        registry.addInterceptor(AuthenticationHelper.getHeaderInterceptor("kdts-ide", "3e8ef952-c1a7-4fdc-9ead-0dc3251ccb2d", "auth-server-url"));
        super.addInterceptors(registry);
    }
}
