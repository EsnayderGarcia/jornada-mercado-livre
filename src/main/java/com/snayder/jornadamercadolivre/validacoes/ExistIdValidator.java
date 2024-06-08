package com.snayder.jornadamercadolivre.validacoes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;
import java.util.Optional;

public class ExistIdValidator implements ConstraintValidator<ExistId, Object> {
    @PersistenceContext
    private EntityManager entityManager;
    private Class<?> domainClass;

    @Override
    public void initialize(ExistId constraintAnnotation) {
        domainClass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(Objects.isNull(value)) return true;
        return Optional.ofNullable(entityManager.find(domainClass, value)).isPresent();
    }
}
