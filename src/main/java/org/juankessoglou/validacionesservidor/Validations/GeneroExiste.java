package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GeneroExisteValidator.class)
public @interface GeneroExiste {

    String message() default "{valid-form.err.genero-existe}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}