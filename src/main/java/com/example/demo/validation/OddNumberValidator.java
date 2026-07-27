package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OddNumberValidator implements ConstraintValidator<OddNumber, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        // Let @NotNull handle the null case; an absent value is not "even".
        return value == null || value % 2 != 0;
    }
}
