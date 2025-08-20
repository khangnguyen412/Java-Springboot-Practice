package com.example.JavaSpingBootPractice.controller.lecture1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.JavaSpingBootPractice.repository.Lecture1NotificationInterface;
import com.example.JavaSpingBootPractice.utils.*;

@RestController
@RequestMapping("/lecture1")
public class Lecture1DependencyInjection {
    private final Lecture1NotificationInterface email_service;
    private final Lecture1Component lecture1_component;

    @Autowired
    public Lecture1DependencyInjection(Lecture1NotificationInterface email_service, Lecture1Component lecture1_component) {
        this.email_service = email_service;
        this.lecture1_component = lecture1_component;
    }

    @RequestMapping("/")
    @ResponseBody
    public String index(@RequestParam(value = "name", defaultValue = "Spring Boot") String name) {
        return String.format("Index %s", name);
    }

    @GetMapping("/annotation-service")
    @ResponseBody
    public String send_email(@RequestParam(value = "name", defaultValue = "Khang") String name) {
        return email_service.send_notification("quốc khang");
    }

    @GetMapping("/annotation-component")
    @ResponseBody
    public String string_to_upper_case() {
        return email_service.send_notification(lecture1_component.to_upper_case("quốc khang"));
    }
}
