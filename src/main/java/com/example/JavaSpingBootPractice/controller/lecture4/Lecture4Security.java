package com.example.JavaSpingBootPractice.controller.lecture4;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lecture4/api")
public class Lecture4Security {
    @GetMapping("/public")
    public String public_request() {
        return "Hello Public (no login needed)";
    }

    @GetMapping("/user")
    public String user_request() {
        return "Hello User - Bạn đã login với role USER";
    }

    @GetMapping("/admin")
    public String admin_request() {
        return "Hello Admin - Bạn đã login với role ADMIN";
    }

}
