package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class MusicaMinimaValidator implements ConstraintValidator<MusicaMinima, List<String>> {

    int musica;

    @Override
    public void initialize(MusicaMinima constraintAnnotation) {
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