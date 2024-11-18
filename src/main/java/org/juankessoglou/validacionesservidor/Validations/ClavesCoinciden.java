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
@Constraint(validatedBy = ClavesCoincidenValidator.class)
@Documented

public @interface ClavesCoinciden {

    String message() default "{valid-form.err.clave.coincide}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    String clave1();
    String clave2();
}