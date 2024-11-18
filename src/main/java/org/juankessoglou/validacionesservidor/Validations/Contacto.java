package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ContactoValidator.class)
@Documented

public @interface Contacto {

    String message() default "{valid-form.err.contacto}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    String email();
    String tlf();
}