package com.mhc.testtemplate.config

import com.mhc.testtemplate.registry.AnnotationsBasedOperationsRegistry
import com.mhc.testtemplate.registry.OperationsRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OperationConfiguration {

    @Bean
    OperationsRegistry operationsRegistry(){
        new AnnotationsBasedOperationsRegistry()
    }

}
