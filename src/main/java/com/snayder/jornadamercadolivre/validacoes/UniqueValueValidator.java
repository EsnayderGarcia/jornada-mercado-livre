package com.snayder.jornadamercadolivre.validacoes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {
    @PersistenceContext
    private EntityManager entityManager;
    private String fieldName;
    private Class<?> domainClass;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        fieldName = constraintAnnotation.fieldName();
        domainClass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery(
           "SELECT 1 FROM " + domainClass.getName() + " WHERE " + fieldName + " = :fieldName"
        ).setParameter("fieldName", value);

        return query.getResultList().isEmpty();
    }
}
