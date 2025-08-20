package com.example.JavaSpingBootPractice.validation.validator;

import jakarta.validation.*;
import com.example.JavaSpingBootPractice.validation.annotation.*;

public class Lecture3FedidValidator implements ConstraintValidator<Lecture3FedidValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return false;
        return value.startsWith("VN") && value.length() >= 9 && value.length() <= 12;
    }
}
