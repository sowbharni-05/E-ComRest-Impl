package com.banfico.EcomApplication.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = PhoneNumberConstraintValidator.class)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface PhoneNumber {

    String message()
    default "PhoneNumber must be valid";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload()default {};


}
