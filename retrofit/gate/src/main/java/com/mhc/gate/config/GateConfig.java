package com.mhc.gate.config;

import com.mhc.gate.service.Api1Service;
import com.mhc.gate.service.Api2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

@Configuration
public class GateConfig {

    @Autowired
    private ServiceConfig serviceConfig;

    @Bean
    public Api1Service getApi1Service(){
        return buildService("api1", Api1Service.class, false);
    }

    @Bean
    Api2Service getApi2Service() {
        return buildService("api2", Api2Service.class, true);
    }

    private <T> T buildService(String serviceName, Class<T> type, boolean forceEnabled){
        Service service = serviceConfig.getService(serviceName);
        if(service == null) {
            throw new IllegalArgumentException("Unknown service " + serviceName);
        }
        if (!service.isEnabled() && !forceEnabled) {
            return null;
        }
        Endpoint endpoint = Endpoints.newFixedEndpoint(service.getBaseUrl());

        RequestInterceptor requestInterceptor = (var1) -> {
            var1.addHeader("h1", "v1");
            var1.addHeader("h2", "v2");
        };

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(endpoint).setRequestInterceptor(requestInterceptor)
                .build();
        return adapter.create(type);
    }
//        new RestAdapter.Builder()
//                .setRequestInterceptor(spinnakerRequestInterceptor)
//      .setEndpoint(endpoint)
//      .setClient(client)
//      .setConverter(new JacksonConverter(objectMapper))
//            .setLogLevel(RestAdapter.LogLevel.valueOf(retrofitLogLevel))
//            .setLog(new Slf4jRetrofitLogger(type))
//            .build()
//      .create(type)

}
