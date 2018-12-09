package com.mhc.api2.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class FirstInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("FirstInterceptor preHandle");
        Enumeration<String> headers = httpServletRequest.getHeaderNames();
        System.out.println("headers:----------------");
        while (headers.hasMoreElements()) {
            String k = headers.nextElement();
            System.out.println(k + " = " +httpServletRequest.getHeader(k));
        }
        System.out.println("-----------------------------------");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("FirstInterceptor afterCompletion");
    }

}
