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
@Constraint(validatedBy = AficionesMinimaValidator.class)
@Documented

public @interface AficionesMinima {

    String message() default "{valid-form.err.aficiones.cantidad}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    int value();

}