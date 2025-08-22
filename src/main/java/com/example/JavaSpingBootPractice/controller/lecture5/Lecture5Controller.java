package com.example.JavaSpingBootPractice.controller.lecture5;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import com.example.JavaSpingBootPractice.model.*;
import com.example.JavaSpingBootPractice.repository.*;
import com.example.JavaSpingBootPractice.services.*;

@RestController
@RequestMapping("/lecture5")
public class Lecture5Controller {
    private final EntityManager em;
    private final Lecture5AccountServices lecture5_account_services;
    private final Lecture5AccountRepository lecture5_account_repository;
    private final Lecture5EmployeeRepository lecture5_employee_repository;
    private final Lecture5EmployeeServices lecture5_employee_services;

    public Lecture5Controller(EntityManager em, Lecture5AccountServices lecture5_account_services, Lecture5AccountRepository lecture5_account_repository, Lecture5EmployeeRepository lecture5_employee_repository, Lecture5EmployeeServices lecture5_employee_services) {
        this.em = em;
        this.lecture5_account_services = lecture5_account_services;
        this.lecture5_account_repository = lecture5_account_repository;
        this.lecture5_employee_services = lecture5_employee_services;
        this.lecture5_employee_repository = lecture5_employee_repository;
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer_money(@RequestParam Integer from_id, @RequestParam Integer to_id, @RequestParam float amount) {
        List<?> data = lecture5_account_services.tranfer_money(from_id, to_id, amount);
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @GetMapping("/test-namedquery")
    public ResponseEntity<?> named_query() {
        List<?> customer_data = em.createNamedQuery("Lecture2CustomerModel.find_by_id").setParameter("custId", 8).getResultList();
        return ResponseEntity.status(HttpStatus.OK).body(customer_data);
    }

    @GetMapping("/test-formula")
    public ResponseEntity<?> test_formula() {
        List<?> customer_data = lecture5_account_repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(customer_data);
    }

    /**
     * Test Lazy Load vs Eager Load
     * đổi các thông số fetch type giữa Lazy và Eager của file: Lecture2AccountModel.java và Lecture5EmployeeModel.java
     * @param id
     * @return
     */
    @GetMapping("/test-lazy-eager/{id}")
    @Transactional
    public Lecture5EmployeeModel testLazy(@PathVariable int id) {
        Lecture5EmployeeModel emp = lecture5_employee_repository.findById(id).orElseThrow();
        System.out.println(emp.getFirstName());
        return emp;
    }

    @GetMapping("/test-cache/{id}")
    public ResponseEntity<?> test_cache(@PathVariable int id) {
        Lecture5EmployeeModel emp = lecture5_employee_services.get_employee_by_id(id);
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }
}
