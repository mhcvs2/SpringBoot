package com.mhc.testtemplate.core

import java.lang.annotation.Annotation

interface Provider {

    String getId()

    String getDisplayName()

    Class<? extends Annotation> getOperationAnnotationType()

}
