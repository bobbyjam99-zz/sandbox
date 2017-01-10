package org.bobbyjam99.web.validate.custom;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class PeriodValidator implements ConstraintValidator<Period, Object> {

    private String fieldFrom;
    private String fieldTo;
    private String message;

    @Override
    public void initialize(Period constraintAnnotation) {
        this.fieldFrom = constraintAnnotation.fieldFrom();
        this.fieldTo = constraintAnnotation.fieldTo();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        BeanWrapper beanWrapper = new BeanWrapperImpl(value);

        Date from = (Date) beanWrapper.getPropertyValue(fieldFrom);
        Date to = (Date) beanWrapper.getPropertyValue(fieldTo);

        if (from != null && to != null && from.compareTo(to) > 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addPropertyNode(fieldFrom).addConstraintViolation();
            return false;
        }
        return true;
    }
}
