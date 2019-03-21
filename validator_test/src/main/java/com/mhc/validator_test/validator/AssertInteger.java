package com.mhc.validator_test.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { AssertIntegerValidator.class})
public @interface AssertInteger {

    String message() default "必须是整数";

    String name();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};

}
