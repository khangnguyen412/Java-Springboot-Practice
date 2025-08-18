package com.example.JavaSpingBootPractice.utils;

import com.example.JavaSpingBootPractice.controller.lecture1.*;
import org.springframework.stereotype.Component;

/**
 * @Component - Annotation cơ bản
 */
@Component("lecture1_component")
public class Lecture1Component {
    public String to_upper_case(String message) {
        return message.toUpperCase();
    }
}