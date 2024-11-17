package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class CheckboxOnValidator implements ConstraintValidator<CheckboxOn, Boolean> {

    @Override
    public boolean isValid(Boolean value, ConstraintValidatorContext context) {
        try {

            return value;
        } catch (Exception e) {
            return false;
        }
    }
}