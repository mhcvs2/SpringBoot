package com.mhc.testtemplate.registry

import com.mhc.testtemplate.operations.Operation

interface OperationsRegistry {

    Operation getOpertation(String name, String providerName)

}