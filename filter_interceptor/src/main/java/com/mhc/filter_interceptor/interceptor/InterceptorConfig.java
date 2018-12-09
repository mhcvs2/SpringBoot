package com.mhc.filter_interceptor.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


//WebMvcConfigurerAdapter 已经被弃用

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FirstInterceptor());
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");;
        super.addInterceptors(registry);
    }
}
