package com.mhc.test.gateway.filters;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;


@Component
@Order(99)
public class TestGatewayFilterFactory
        extends AbstractNameValueGatewayFilterFactory
{
    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return (exchange, chain) -> {
            System.out.println("test pre--------------");
            System.out.println("name: " + config.getName() + ", value: " + config.getValue());
            return chain.filter(exchange).then().then(Mono.fromRunnable(() -> {
                System.out.println("test post-----------------------");
            }));
        };
    }
}