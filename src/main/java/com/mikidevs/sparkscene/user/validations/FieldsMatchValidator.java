package com.mikidevs.sparkscene.user.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class FieldsMatchValidator implements ConstraintValidator<FieldsMatch, Object> {

    private String firstField;
    private String secondField;
    private String message;

    @Override
    public void initialize(FieldsMatch constraintAnnotation) {
        this.firstField = constraintAnnotation.firstField();
        this.secondField = constraintAnnotation.secondField();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            Field firstFieldValue = value.getClass().getDeclaredField(firstField);
            Field secondFieldValue = value.getClass().getDeclaredField(secondField);

            firstFieldValue.setAccessible(true);
            secondFieldValue.setAccessible(true);

            Object firstValue = firstFieldValue.get(value);
            Object secondValue = secondFieldValue.get(value);

            boolean valid = (firstValue == null && secondValue == null) || 
                            (firstValue != null && firstValue.equals(secondValue));

            if (!valid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(message)
                       .addPropertyNode(secondField)
                       .addConstraintViolation();
            }

            return valid;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
