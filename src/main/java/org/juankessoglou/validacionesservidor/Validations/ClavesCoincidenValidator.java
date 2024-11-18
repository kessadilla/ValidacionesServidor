package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;

public class ClavesCoincidenValidator implements ConstraintValidator<ClavesCoinciden, Object> {

    String clave1;
    String clave2;

    @Override
    public void initialize(ClavesCoinciden constraintAnnotation) {
        this.clave1 = constraintAnnotation.clave1();
        this.clave2 = constraintAnnotation.clave2();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {

            Field clave1Field = value.getClass().getDeclaredField(this.clave1);
            clave1Field.setAccessible(true);
            String c1 = (String) clave1Field.get(value);

            Field clave2Field = value.getClass().getDeclaredField(this.clave2);
            clave2Field.setAccessible(true);
            String c2 = (String) clave2Field.get(value);

            return c1.equals(c2);


        } catch (Exception e) {
            return false;
        }
    }
}