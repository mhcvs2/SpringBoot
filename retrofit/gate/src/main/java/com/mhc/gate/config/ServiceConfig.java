package com.mhc.gate.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties
public class ServiceConfig {

    private List<String> healthCheckableServices = new ArrayList<>();
    private Map<String, Service> services = new HashMap<>();

    @PostConstruct
    void postConstruct() {
        // this check is done in a @PostConstruct to avoid Spring's list merging in @ConfigurationProperties (vs. overriding)
        if(healthCheckableServices.size() == 0) {
            healthCheckableServices.add("api1");
            healthCheckableServices.add("api2");
        }
    }

    public List<String> getHealthCheckableServices() {
        return healthCheckableServices;
    }

    public void setHealthCheckableServices(List<String> healthCheckableServices) {
        this.healthCheckableServices = healthCheckableServices;
    }

    public Map<String, Service> getServices() {
        return services;
    }

    public void setServices(Map<String, Service> services) {
        this.services = services;
    }

    public Service getService(String name) {
        return this.services.get(name);
    }
}
