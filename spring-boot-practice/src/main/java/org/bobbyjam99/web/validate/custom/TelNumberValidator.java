package org.bobbyjam99.web.validate.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelNumberValidator implements ConstraintValidator<TelNumber, String> {

    private Pattern pattern;

    @Override
    public void initialize(TelNumber constraintAnnotation) {
        pattern = Pattern.compile("^0\\d*-\\d-\\d*");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}
