package com.example.JavaSpingBootPractice.controller.lecture1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.example.JavaSpingBootPractice.utils.*;

/**
 * Dependency Injection
 * - Là một kỹ thuật lập trình trong đó một đối tượng (hoặc component) không tự tạo các dependency của nó mà được tiếp nhận các dependency từ bên ngoài (thường là container DI).
 */
@RestController
@RequestMapping("/lecture1")
public class Lecture1DependencyInjection {
    private final Lecture1InterfaceNotification email_service;

    @Autowired
    public Lecture1DependencyInjection(Lecture1InterfaceNotification email_service) {
        this.email_service = email_service;
    }

    @GetMapping("/annotation-service")
    @ResponseBody
    public String send_email(@RequestParam(value = "name", defaultValue = "Khang") String name) {
        return email_service.send_notification("khang@gmail.com");
    }

    @GetMapping("/annotation-component")
    @ResponseBody
    public String string_to_upper_case() {
        String name = email_service.to_upper_case("quốc khang");
        return email_service.send_notification(name);
    }

    @RequestMapping("/")
    @ResponseBody
    public String index(@RequestParam(value = "name", defaultValue = "Spring Boot") String name) {
        return String.format("Index %s", name);
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
