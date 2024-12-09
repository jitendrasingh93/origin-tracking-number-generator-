package com.tracking.generate.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class WeightValidator implements ConstraintValidator<WeightConstraints, Double> {
    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ssXXX";
    private static final DecimalFormat dfZero = new DecimalFormat("0.00");
    private static final DecimalFormat dfSharp = new DecimalFormat("#.##");

    @Override
    public boolean isValid(Double weight, ConstraintValidatorContext cxt) {
        String[] split = String.valueOf(weight).split("\\.");
        if (split.length <=2 && split[1].length() <= 3) {
            return true;
        }
        return false;
    }

}
