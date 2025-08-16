package com.example.JavaSpingBootPractice.controller.lecture1;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Dependency Injection
 * - Là một kỹ thuật lập trình trong đó một đối tượng (hoặc component) không tự tạo các dependency của nó mà được tiếp nhận các dependency từ bên ngoài (thường là container DI).
 */
interface notification {
    void send_notification(String message);
}

@Component
class email_service implements notification {
    @Override
    public void send_notification(String message) {
        System.out.println("sending to email: " + message);
    }
}

@Component
class sms_service implements notification {
    @Override
    public void send_notification(String message) {
        System.out.println("sending to sms:" + message);
    }
}

/**
 * @Component - Annotation cơ bản
 */
@Component
class user_component {
    // Logic của service
}

/**
 * @Service - Specialized Component
 */
@Service  // Đánh dấu service layer
// public class user_services {}

/**
 * @Repository - Database layer
 */
@Repository  // Đánh dấu repository
//public class user_repository {}

@RestController
@RequestMapping("/lecture1")
public class lecture1 {
    private final notification email_service;
    private final notification sms_service;

    @Autowired
    public lecture1(notification email_service, notification sms_service) {
        this.email_service = email_service;
        this.sms_service = sms_service;
    }

    public void send_confirm(String order) {
        email_service.send_notification(order);
    }

    @GetMapping("/")
    @ResponseBody
    public String index(@RequestParam(value = "name", defaultValue = "Spring Boot") String name) {
        return String.format("Index %s", name);
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/send-email")
    @ResponseBody
    public String send_email(@RequestParam(value = "name", defaultValue = "Khang") String name) {
        sms_service.send_notification("Test message via email");
        return "Email sent to " + name;
    }

    @GetMapping("/send-sms")
    @ResponseBody
    public String send_sms(@RequestParam(value = "name", defaultValue = "Khang") String name) {
        sms_service.send_notification("Test message via sms");
        return "SMS sent to " + name;
    }
}
