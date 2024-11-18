package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class AficionesMinimaValidator implements ConstraintValidator<AficionesMinima, List<String>> {

    int aficiones;

    @Override
    public void initialize(AficionesMinima constraintAnnotation) {
        this.aficiones = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        try {

            if (value == null || value.isEmpty()) {
                return true;
            }
            return aficiones <= value.size();
        } catch (Exception e) {
            return false;
        }
    }
}