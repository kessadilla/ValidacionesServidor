package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CaracterValidator implements ConstraintValidator<Caracter, String> {



    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            if (value == null || value.isEmpty()) {
                return true;
            }
            for (int i = 0; i < value.length(); i++) {
                String a = value.charAt(i) + "";
                if (a.equals("!") || a.equals("#") || a.equals("$") || a.equals("%") || a.equals("&")) {
                    return true;
                }
            }
            return false;

        } catch (Exception e) {
            return false;
        }
    }
}