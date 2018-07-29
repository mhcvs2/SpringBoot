package com.mhc.testtemplate.operations.two

import com.mhc.testtemplate.operations.Operation
import com.mhc.testtemplate.providers.TwoOperationAnnotation
import org.springframework.stereotype.Component

@Component
@TwoOperationAnnotation("to1")
class TwoOperation1 implements Operation {

    @Override
    void doSomething() {
        println("TwoOperation1 do something")
    }
}
