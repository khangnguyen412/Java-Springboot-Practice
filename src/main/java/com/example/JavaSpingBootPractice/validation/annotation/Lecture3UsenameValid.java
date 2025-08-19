package com.example.JavaSpingBootPractice.validation.annotation;

import java.lang.annotation.*;
import jakarta.validation.*;

@Documented
@Constraint(validatedBy = com.example.JavaSpingBootPractice.validation.validator.Lecture3UserValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Lecture3UsenameValid {
    String message() default "Username is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
