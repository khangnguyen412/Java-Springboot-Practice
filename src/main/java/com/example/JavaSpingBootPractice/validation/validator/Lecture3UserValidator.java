package com.example.JavaSpingBootPractice.validation.validator;

import jakarta.validation.*;
import com.example.JavaSpingBootPractice.validation.annotation.*;

public class Lecture3UserValidator implements ConstraintValidator<Lecture3UsenameValid, String> {
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return false;
    }
}
