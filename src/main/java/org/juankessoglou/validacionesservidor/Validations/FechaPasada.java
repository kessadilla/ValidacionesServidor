package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = FechaPasadaValidator.class)
@Documented

public @interface FechaPasada {

    String message() default "{valid-form.err.fecha.pasada}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    int value();

}