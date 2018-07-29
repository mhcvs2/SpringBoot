package com.mhc.testtemplate.operations.one

import com.mhc.testtemplate.operations.Operation
import com.mhc.testtemplate.providers.OneOperationAnnotation
import org.springframework.stereotype.Component

@Component
@OneOperationAnnotation("oo2")
class OneOperation2 implements Operation {

    @Override
    void doSomething() {
        println("OneOperation2 do something")
    }
}
