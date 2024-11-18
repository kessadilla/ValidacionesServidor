package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;

public class ContactoValidator implements ConstraintValidator<Contacto, Object> {

    String email;
    String tlf;

    @Override
    public void initialize(Contacto constraintAnnotation) {
        this.email = constraintAnnotation.email();
        this.tlf = constraintAnnotation.tlf();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {

            Field emailField = value.getClass().getDeclaredField(this.email);
            emailField.setAccessible(true);
            String e = (String) emailField.get(value);

            Field tlfField = value.getClass().getDeclaredField(this.tlf);
            tlfField.setAccessible(true);
            String t = (String) tlfField.get(value);

            if ((e == null || e.isEmpty()) && (t == null || t.isEmpty())) {
                return false;
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}