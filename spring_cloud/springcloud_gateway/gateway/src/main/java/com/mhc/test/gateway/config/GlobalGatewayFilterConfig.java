package com.mhc.test.gateway.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Configuration
public class GlobalGatewayFilterConfig {

    @Bean
    @Order(-100)
    public GlobalFilter elapsedGlobalFilter()
    {
        return (exchange, chain) -> {
            //调用请求之前统计时间
            Long startTime = System.currentTimeMillis();
            return chain.filter(exchange).then().then(Mono.fromRunnable(() -> {
                //调用请求之后统计时间
                Long endTime = System.currentTimeMillis();
                System.out.println(
                        exchange.getRequest().getURI().getRawPath() + ", cost time : " + (endTime - startTime) + "ms");
            }));
        };
    }
}
