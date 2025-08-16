package com.example.JavaSpingBootPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Annotation chính của ứng dụng
 * Spring sẽ tự động tìm các class có @Component, @Service, @Repository, @Controller
 */
@SpringBootApplication
public class JavaSpingBootPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaSpingBootPracticeApplication.class, args);
    }
}
