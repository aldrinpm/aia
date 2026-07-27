package com.example.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.RECORD_COMPONENT;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/** Validates that an integer value is odd. {@code null} is considered valid. */
@Documented
@Constraint(validatedBy = OddNumberValidator.class)
@Target({FIELD, PARAMETER, RECORD_COMPONENT})
@Retention(RUNTIME)
public @interface OddNumber {
    String message() default "must be an odd integer";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
