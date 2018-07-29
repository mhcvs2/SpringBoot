package com.mhc.testtemplate.providers

import com.mhc.testtemplate.core.Provider
import org.springframework.stereotype.Component

import java.lang.annotation.Annotation

@Component
class OneProvider implements Provider {

    static final String ID = "1"

    final String id = ID

    final String displayName = "One"

    final Class<Annotation> operationAnnotationType = OneOperationAnnotation

}
