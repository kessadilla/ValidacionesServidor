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
@Constraint(validatedBy = CaracterValidator.class)
@Documented

public @interface Caracter {

    String message() default "{valid-form.err.clave.carac}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}