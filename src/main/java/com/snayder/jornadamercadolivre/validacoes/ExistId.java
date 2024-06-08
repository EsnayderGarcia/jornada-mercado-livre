package com.snayder.jornadamercadolivre.validacoes;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {ExistIdValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface ExistId {
    String message();
    Class<?> domainClass();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
