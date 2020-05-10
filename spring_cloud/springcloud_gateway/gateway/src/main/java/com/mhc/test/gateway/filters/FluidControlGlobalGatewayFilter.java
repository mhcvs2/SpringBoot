package com.mhc.test.gateway.filters;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class FluidControlGlobalGatewayFilter implements GlobalFilter, Ordered {

    int capacity = 5;
    int refillTokens = 1;
    Duration duration = Duration.ofSeconds(1);

    private static final Map<String, Bucket> BUCKET_CACHE = new ConcurrentHashMap<>();

    private Bucket createNewBucket(){
        Refill refill = Refill.greedy(refillTokens, duration);
        Bandwidth limit = Bandwidth.classic(capacity, refill);
        return Bucket4j.builder().addLimit(limit).build();
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
    {
        String ip = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
        Bucket bucket = BUCKET_CACHE.computeIfAbsent(ip, k -> createNewBucket());

        System.out.println("IP: " + ip + "，has Tokens: " + bucket.getAvailableTokens());
        if (bucket.tryConsume(1))
        {
            return chain.filter(exchange);
        }
        else
        {
            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
            return exchange.getResponse().setComplete();
        }
    }

    @Override
    public int getOrder()
    {
        return -1000;
    }
}
