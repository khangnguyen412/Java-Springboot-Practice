package com.example.JavaSpingBootPractice.controller.lecture2;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.example.JavaSpingBootPractice.model.*;
import com.example.JavaSpingBootPractice.services.*;


@RestController
@RequestMapping("/lecture2/api")
public class Lecture2Controller {
    private final Lecture2Services lecture2_services;

    public Lecture2Controller(Lecture2Services lecture2_services) {
        this.lecture2_services = lecture2_services;
    }
    
    @GetMapping("/get-all")
    public ResponseEntity<List<Lecture2Model>> get_all_account() {
        List<Lecture2Model> data = lecture2_services.get_all_account();
        if (lecture2_services.get_all_account().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }
}
