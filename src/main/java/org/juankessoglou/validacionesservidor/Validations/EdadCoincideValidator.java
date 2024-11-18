package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.yaml.snakeyaml.util.EnumUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

public class EdadCoincideValidator implements ConstraintValidator<EdadCoincide, Object> {

    String fechaNacimiento;
    String edad;

    @Override
    public void initialize(EdadCoincide constraintAnnotation) {
        fechaNacimiento = constraintAnnotation.fecha();
        edad = constraintAnnotation.edad();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {

            if (value == null){
                return true;
            }
            Field fechaField = value.getClass().getDeclaredField(this.fechaNacimiento);
            fechaField.setAccessible(true);
            LocalDate fechaNacimiento = (LocalDate) fechaField.get(value);

            if (fechaNacimiento == null) return true;

            Field edadField = value.getClass().getDeclaredField(this.edad);
            edadField.setAccessible(true);
            Integer edadN = (Integer) edadField.get(value);

            int edadCalculada = Period.between(fechaNacimiento, LocalDate.now()).getYears();

            return edadCalculada == edadN;
        } catch (Exception e) {
            return false;
        }
    }
}