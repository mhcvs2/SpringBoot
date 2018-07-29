package com.mhc.testtemplate.operations.one

import com.mhc.testtemplate.operations.Operation
import com.mhc.testtemplate.providers.OneOperationAnnotation
import org.springframework.stereotype.Component

@Component
@OneOperationAnnotation("oo1")
class OneOperation1 implements Operation {

    @Override
    void doSomething() {
        println("OneOperation1 do something")
    }
}
