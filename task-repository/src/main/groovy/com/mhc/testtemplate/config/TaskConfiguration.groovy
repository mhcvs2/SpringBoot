package com.mhc.testtemplate.config

import com.mhc.testtemplate.repository.task.InMemoryTaskRepository
import com.mhc.testtemplate.repository.task.TaskRepository
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TaskConfiguration {

    @Bean
    @ConditionalOnMissingBean(TaskRepository)
    TaskRepository taskRepository() {
        new InMemoryTaskRepository()
    }

}
