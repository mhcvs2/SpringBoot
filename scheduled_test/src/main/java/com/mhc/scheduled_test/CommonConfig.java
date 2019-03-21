package com.mhc.scheduled_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class CommonConfig {

    @Autowired
    ScheduledTaskRegistrar scheduledTaskRegistrar;

}
