package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MusicaValidator implements ConstraintValidator<Musica, List<String>> {

    int musica;

    @Override
    public void initialize(Musica constraintAnnotation) {
        this.musica = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        try {
            return musica <= value.size();
        } catch (Exception e) {
            return false;
        }
    }
}