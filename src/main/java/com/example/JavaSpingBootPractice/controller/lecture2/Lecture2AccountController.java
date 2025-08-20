package com.example.JavaSpingBootPractice.controller.lecture2;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.example.JavaSpingBootPractice.model.*;
import com.example.JavaSpingBootPractice.services.*;


@RestController
@RequestMapping("/lecture2/api/account")
public class Lecture2AccountController {
    private static final Logger logger = LoggerFactory.getLogger(Lecture2AccountController.class);
    private final Lecture2AccountServices lecture2_services;

    public Lecture2AccountController(Lecture2AccountServices lecture2_services) {
        this.lecture2_services = lecture2_services;
    }
    
    @GetMapping("/get-all")
    public ResponseEntity<List<Lecture2AccountModel>> get_all_account() {
        List<Lecture2AccountModel> data = lecture2_services.get_all_account();
        if (lecture2_services.get_all_account().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping("/fillter-balance/{price}")
    public ResponseEntity<List<Lecture2AccountModel>> fillter_balance(@PathVariable float price) {
        List<Lecture2AccountModel> data = lecture2_services.fillterBalance(price);
        logger.info("get data: {}", data);
        if (lecture2_services.fillterBalance(price).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping("/fillter-balance-native/{price}")
    public ResponseEntity<List<Lecture2AccountModel>> get_by_balance(@PathVariable long price) {
        List<Lecture2AccountModel> data = lecture2_services.findByBalanceNative(price);
        if (lecture2_services.findByBalanceNative(price).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

}
