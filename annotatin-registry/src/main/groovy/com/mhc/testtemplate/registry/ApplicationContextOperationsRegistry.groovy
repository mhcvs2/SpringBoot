package com.mhc.testtemplate.registry

import com.mhc.testtemplate.operations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

class ApplicationContextOperationsRegistry implements OperationsRegistry {

    @Autowired
    ApplicationContext applicationContext

    @Override
    Operation getOpertation(String name, String providerName) {
        (Operation) applicationContext.getBean(name)
    }
}
