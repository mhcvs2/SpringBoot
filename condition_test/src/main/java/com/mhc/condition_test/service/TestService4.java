package com.mhc.condition_test.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@ConditionalOnProperty(prefix = "test1", name = "key99", matchIfMissing = false)
@Service
public class TestService4 implements TestInterface {
}
