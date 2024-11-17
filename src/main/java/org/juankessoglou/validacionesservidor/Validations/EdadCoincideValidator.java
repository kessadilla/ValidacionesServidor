package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class EdadCoincideValidator implements ConstraintValidator<EdadCoincide, Integer> {

    LocalDate fechaNacimiento;


    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        try {

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}