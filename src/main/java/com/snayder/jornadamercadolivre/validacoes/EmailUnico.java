package com.snayder.jornadamercadolivre.validacoes;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {EmailUnicoValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface EmailUnico {
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
