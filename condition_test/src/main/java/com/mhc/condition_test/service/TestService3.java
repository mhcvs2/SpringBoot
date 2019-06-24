package com.mhc.condition_test.service;

import org.springframework.stereotype.Service;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(prefix = "test1", name = "key99", matchIfMissing = true)
@Service
public class TestService3 implements TestInterface {
}










