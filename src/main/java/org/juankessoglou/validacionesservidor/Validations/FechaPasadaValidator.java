package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FechaPasadaValidator implements ConstraintValidator<FechaPasada, LocalDate> {

    int aniosMinimosPasados;

    @Override
    public void initialize(FechaPasada constraintAnnotation) {
        this.aniosMinimosPasados = constraintAnnotation.value();
    }


    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate fechaAhora = LocalDate.now();
            int anioAhora = fechaAhora.getYear();
            int anioUsuario = value.getYear();

            return anioAhora - anioUsuario >= aniosMinimosPasados;

        } catch (Exception e) {
            return false;
        }
    }
}