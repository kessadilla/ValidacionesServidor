package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.juankessoglou.validacionesservidor.Model.Colecciones;
import org.juankessoglou.validacionesservidor.Model.Pais;

import java.util.Map;

public class PaisExisteValidator implements ConstraintValidator<PaisExiste, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        Map<String, Pais> pais = Colecciones.getListaPaises();
        return pais.containsKey(value);
    }
}