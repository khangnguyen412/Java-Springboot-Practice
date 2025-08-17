package com.example.JavaSpingBootPractice.services;

import com.example.JavaSpingBootPractice.controller.lecture1.Lecture1InterfaceNotification;
import org.springframework.stereotype.Service;

/**
 * @Service - Specialized Component
 */
//@Service  // Đánh dấu service layer
public class Lecture1Services implements Lecture1InterfaceNotification {
    @Override
    public String send_notification(String message) {
        return "Sending to email: " + message;
    }


}

/**
 * @Repository - Database layer
 */
//@Repository // Đánh dấu repository
//public class user_repository {}