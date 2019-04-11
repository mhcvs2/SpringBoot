package com.mhc.validator_test.validator.InEnum;

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
@Constraint(validatedBy = { EnumValueValidator.class})
public @interface EnumValue {

    String message() default "";

    Class<? extends Enum<?>> enumClass();

    String fieldName();

    String friendlyName();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};

}
