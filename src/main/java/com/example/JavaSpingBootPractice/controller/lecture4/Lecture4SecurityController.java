package com.example.JavaSpingBootPractice.controller.lecture4;

import org.springframework.web.bind.annotation.*;

import com.example.JavaSpingBootPractice.dto.*;
import com.example.JavaSpingBootPractice.security.jwt.*;

@RestController
@RequestMapping("/lecture4")
public class Lecture4SecurityController {
    private final JwtTokenProvider jwt_util;

    public Lecture4SecurityController(JwtTokenProvider jwt_util) {
        this.jwt_util = jwt_util;
    }

    @GetMapping("/api/public")
    public String public_request() {
        return "Hello Public (no login needed)";
    }

    @GetMapping("/api/user")
    public String user_request() {
        return "Hello User - Bạn đã login với role USER";
    }

    @GetMapping("/api/admin")
    public String admin_request() {
        return "Hello Admin - Bạn đã login với role ADMIN";
    }

    @PostMapping("/login")
    public String login(@RequestBody Lecture4UserDTO loginRequest) {
        if (loginRequest.getUsername().equals("admin") && loginRequest.getPassword().equals("123456")) {
            String token = jwt_util.generate_token(loginRequest.getUsername(), "ADMIN");

            return "Login success - Token: " + token;
        }else if (loginRequest.getUsername().equals("khangnguyen") && loginRequest.getPassword().equals("123456")) {
            String token = jwt_util.generate_token(loginRequest.getUsername(), "USER");
            return "Login success - Token: " + token;
        }
        return "Login failed";
    }
}
