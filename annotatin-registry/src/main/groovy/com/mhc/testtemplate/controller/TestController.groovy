package com.mhc.testtemplate.controller

import com.mhc.testtemplate.operations.Operation
import com.mhc.testtemplate.registry.OperationsRegistry
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/test")
class TestController {

    @Autowired
    OperationsRegistry operationsRegistry

    @RequestMapping(value = "/{provider:.+}/{name:.+}", method = RequestMethod.GET)
    String tc1(@PathVariable String provider, @PathVariable String name) {
        Operation operation = operationsRegistry.getOpertation(name, provider)
        operation.doSomething()
        "success"
    }

}
