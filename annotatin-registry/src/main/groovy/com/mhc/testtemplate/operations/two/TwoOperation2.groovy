package com.mhc.testtemplate.operations.two

import com.mhc.testtemplate.operations.Operation
import com.mhc.testtemplate.providers.TwoOperationAnnotation
import org.springframework.stereotype.Component

@Component
@TwoOperationAnnotation("to2")
class TwoOperation2 implements Operation {

    @Override
    void doSomething() {
        println("TwoOperation2 do something")
    }
}
