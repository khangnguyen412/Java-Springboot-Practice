package com.example.JavaSpingBootPractice.validation.annotation;

import java.lang.annotation.*;
import jakarta.validation.*;

@Documented
@Constraint(validatedBy = com.example.JavaSpingBootPractice.validation.validator.Lecture3FedidValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Lecture3FedidValid {
    String message() default "Fedid is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
