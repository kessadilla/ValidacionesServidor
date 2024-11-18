package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.juankessoglou.validacionesservidor.Model.Colecciones;

import java.util.Map;

public class GeneroExisteValidator implements ConstraintValidator<GeneroExiste, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        Map<String, String> generos = Colecciones.getListaGeneros();
        return generos.containsKey(value);
    }
}