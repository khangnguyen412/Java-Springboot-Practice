package com.example.JavaSpingBootPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @SpringBootApplication là annotation chính của ứng dụng
 * - Đã bảo gồm @ComponentScan là annotation để scan các class có @Component, @Service, @Repository, @Controller
 */
@SpringBootApplication
@RestController
public class JavaSpingBootPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaSpingBootPracticeApplication.class, args);
    }

    @GetMapping("/")
    public static String index_page() {
        return "Hello World!";
    }
}
