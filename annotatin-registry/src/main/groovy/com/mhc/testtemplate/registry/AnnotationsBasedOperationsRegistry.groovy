package com.mhc.testtemplate.registry

import com.mhc.testtemplate.core.Provider
import com.mhc.testtemplate.exceptions.OperationNotFoundException
import com.mhc.testtemplate.exceptions.ProviderNotFoundException
import com.mhc.testtemplate.operations.Operation
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.beans.factory.annotation.Autowired

import java.lang.annotation.Annotation

class AnnotationsBasedOperationsRegistry extends ApplicationContextOperationsRegistry {

    @Autowired
    List<Provider> providers

    @Override
    Operation getOpertation(String name, String providerName) {
        try {
            Operation operation = super.getOpertation(name, providerName)
            if (operation) return operation
        } catch (NoSuchBeanDefinitionException e) {
            println(e.message)
        }

        Class<? extends Annotation> providerAnnotationType = getProviderAnnotation(providerName)

        List operations = applicationContext.getBeansWithAnnotation(providerAnnotationType).findAll {
            key, value ->
                value.getClass().getAnnotation(providerAnnotationType).value() == name &&
                        value instanceof Operation
        }.values().toList()
        if (!operations) {
            throw new OperationNotFoundException(
                    "No operation found for name '${name}' and provider '${providerName}'"
            )
        }

        if (operations.size() > 1) {
            throw new RuntimeException(
                    "More than one (${operations.size()}) operation found for name '${name}' and provider " +
                            "'${providerName}'"
            )
        }

        return (Operation) operations.first()
    }

    protected Class<? extends Annotation> getProviderAnnotation(String provider) {
        List<Provider> providerInstances = providers.findAll { it.id == provider }
        if(!providerInstances) {
            throw new ProviderNotFoundException("No provider named ${provider} found")
        }
        if (providerInstances.size() > 1) {
            throw new RuntimeException(
              "More than one (${providerInstances.size()}) cloud providers found for the identifier '${provider}'"
            )
        }
        providerInstances.first().getOperationAnnotationType()
    }
}
