package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.juankessoglou.validacionesservidor.Model.Colecciones;
import org.juankessoglou.validacionesservidor.Model.Pais;

import java.util.List;
import java.util.Map;

public class PrefijoExisteValidator implements ConstraintValidator<PrefijoExiste, String> {

    private static final Map<String, Pais> listaPaises = Colecciones.getListaPaises();

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return listaPaises.values().stream()
                .anyMatch(pais -> pais.getPrefijoTelefonicoPais().equals(value));
    }
}