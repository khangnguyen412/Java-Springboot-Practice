package com.example.JavaSpingBootPractice.utils;

import com.example.JavaSpingBootPractice.controller.lecture1.*;
import org.springframework.stereotype.Component;

/**
 * @Component - Annotation cơ bản
 */
@Component
public class Lecture1Component implements Lecture1InterfaceNotification {
    @Override
    public String send_notification(String message) {
        return "Notification: " + to_upper_case(message);
    }

    public String to_upper_case(String input) {
        return input.toUpperCase();
    }
}