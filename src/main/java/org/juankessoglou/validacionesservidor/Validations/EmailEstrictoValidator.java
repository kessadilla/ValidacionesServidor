package org.juankessoglou.validacionesservidor.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailEstrictoValidator implements ConstraintValidator<EmailEstricto, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        try {

            if (value.equals("") || value == null) {
                return true;
            }
            Pattern pattern =
                    Pattern.compile("[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}");
            Matcher matcher = pattern.matcher(value);

            return matcher.matches();

        } catch (Exception e) {
            return false;
        }
    }
}