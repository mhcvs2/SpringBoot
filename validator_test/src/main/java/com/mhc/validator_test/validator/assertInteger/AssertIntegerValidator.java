package com.mhc.validator_test.validator.assertInteger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AssertIntegerValidator implements ConstraintValidator<AssertInteger, String> {

    private String name;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null || s.equals("")){
            return true;
        }
        try {
            Integer.valueOf(s);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    @Override
    public void initialize(AssertInteger constraintAnnotation) {
        name = constraintAnnotation.name();
    }
}
