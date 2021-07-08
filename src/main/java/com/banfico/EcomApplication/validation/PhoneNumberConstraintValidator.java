package com.banfico.EcomApplication.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberConstraintValidator implements ConstraintValidator<PhoneNumber,String> {


    @Override
    public boolean isValid(String number, ConstraintValidatorContext constraintValidatorContext) {

        Pattern pattern = Pattern.compile("(0|91)?[7-9][0-9]{9}");
        Matcher matcher = pattern.matcher(number);
        return(matcher.matches());
    }
}
