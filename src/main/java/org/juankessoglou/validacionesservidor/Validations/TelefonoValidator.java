package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class TelefonoValidator implements ConstraintValidator<Telefono, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            if (value.length() != 9) return false;

            Integer.parseInt(value);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}