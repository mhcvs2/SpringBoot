package com.mhc.testtemplate.controller

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/test")
class TestController {

    @RequestMapping(value = "/{name:.+}", method = RequestMethod.GET)
    String tc1(@PathVariable String name) {
        name
    }

}
