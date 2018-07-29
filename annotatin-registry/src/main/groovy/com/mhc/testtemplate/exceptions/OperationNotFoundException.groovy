package com.mhc.testtemplate.exceptions

import groovy.transform.InheritConstructors
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@InheritConstructors
class OperationNotFoundException extends RuntimeException {}
