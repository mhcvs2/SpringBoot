package com.mhc.validator_test.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ConvertIntegerException extends JsonProcessingException {

    public ConvertIntegerException(String message) {
        super(message);
    }
}
