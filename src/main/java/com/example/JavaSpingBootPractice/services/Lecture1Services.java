package com.example.JavaSpingBootPractice.services;

import org.springframework.stereotype.Service;

import com.example.JavaSpingBootPractice.repository.Lecture1NotificationInterface;

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