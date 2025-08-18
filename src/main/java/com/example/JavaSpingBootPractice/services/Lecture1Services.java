package com.example.JavaSpingBootPractice.services;

import com.example.JavaSpingBootPractice.controller.lecture1.Lecture1NotificationInterface;
import org.springframework.stereotype.Service;

/**
 * @Service - Specialized Component
 */
@Service  // Đánh dấu service layer
public class Lecture1Services implements Lecture1NotificationInterface {
    @Override
    public String send_notification(String message) {
        return "Sending to email: " + message;
    }
}