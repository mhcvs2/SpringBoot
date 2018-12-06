package com.mhc.api1.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Component
@Order(1)
@WebFilter(urlPatterns = {"/*"},filterName = "PassportAccessFilter")
public class Api1Filter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Enumeration<String> headers = httpServletRequest.getHeaderNames();
        System.out.println("headers:----------------");
        while (headers.hasMoreElements()) {
            String k = headers.nextElement();
            System.out.println(k + " = " +httpServletRequest.getHeader(k));
        }
        System.out.println("-----------------------------------");
        filterChain.doFilter(servletRequest,servletResponse);


//        if(responseParam != null&&responseParam.getStatus()!= ResponseCodeEnum.SUCCESS.getCode()){
//            PrintWriter out = ((HttpServletResponse)
//                    servletResponse).getWriter();
//            out.write(responseParam.toJSONString());
//            out.flush();
//        }else{
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
    }

    @Override
    public void destroy() {

    }
}
