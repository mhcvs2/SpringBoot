package com.mhc.testtemplate.providers

import com.mhc.testtemplate.core.Provider
import org.springframework.stereotype.Component

import java.lang.annotation.Annotation

@Component
class TwoProvider implements Provider {

    static final String ID = "2"

    final String id = ID

    final String displayName = "Two"

    final Class<Annotation> operationAnnotationType = TwoOperationAnnotation

}
