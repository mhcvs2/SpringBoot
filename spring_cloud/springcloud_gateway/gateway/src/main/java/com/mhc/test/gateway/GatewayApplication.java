package com.mhc.test.gateway;

import com.mhc.test.gateway.utils.AuthUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(GatewayApplication.class);
        springApplication.addListeners(new ApplicationListenerStarted());
        springApplication.run(args);
    }

    private static class ApplicationListenerStarted implements ApplicationListener<ApplicationEvent> {
        @Override
        public void onApplicationEvent(ApplicationEvent applicationEvent) {
            AuthUtil.init();
        }
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/customize/hello/**")
                        .filters(f -> f.stripPrefix(1)
                                .addRequestHeader("extendtag", "geteway-" + System.currentTimeMillis()))
                        .uri("lb://provider")
                ).build();
    }

}
