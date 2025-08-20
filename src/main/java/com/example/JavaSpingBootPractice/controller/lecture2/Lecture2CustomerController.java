package com.example.JavaSpingBootPractice.controller.lecture2;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.JavaSpingBootPractice.dto.Lecture3CustomerDTO;
import com.example.JavaSpingBootPractice.services.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/lecture2/api/customer")
public class Lecture2CustomerController {
    private final Lecture2CustomerServices lecture2_customer_services;

    public Lecture2CustomerController(Lecture2CustomerServices lecture2_customer_services) {
        this.lecture2_customer_services = lecture2_customer_services;
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> get_all_customers() {
        List<?> data = lecture2_customer_services.get_all_customers();
        if (lecture2_customer_services.get_all_customers().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Ko tìm thấy khách hàng ");
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add_customers(@Valid @RequestBody Lecture3CustomerDTO customerDTO) {
        lecture2_customer_services.add_customer(customerDTO);
        List<?> data = lecture2_customer_services.get_all_customers();
        return ResponseEntity.ok(data);
    }
}
