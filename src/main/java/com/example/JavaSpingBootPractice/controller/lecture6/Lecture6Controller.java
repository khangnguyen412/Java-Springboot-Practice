package com.example.JavaSpingBootPractice.controller.lecture6;

import java.util.*;
import java.util.concurrent.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;

import com.example.JavaSpingBootPractice.model.*;
import com.example.JavaSpingBootPractice.repository.*;
import com.example.JavaSpingBootPractice.services.*;

@RestController
@RequestMapping("/lecture6")
public class Lecture6Controller {
    private final Lecture5AccountServices lecture5_account_services;
    private final Lecture5AccountRepository lecture5_account_repository;
    private final Lecture5EmployeeRepository lecture5_employee_repository;
    private final Lecture5EmployeeServices lecture5_employee_services;
    private final Lecture6AsyncProcessingServices lecture6_async_services;


    public Lecture6Controller( Lecture5AccountServices lecture5_account_services, Lecture5AccountRepository lecture5_account_repository, Lecture5EmployeeRepository lecture5_employee_repository, Lecture5EmployeeServices lecture5_employee_services, Lecture6AsyncProcessingServices lecture6_async_services) {
        this.lecture5_account_services = lecture5_account_services;
        this.lecture5_account_repository = lecture5_account_repository;
        this.lecture5_employee_services = lecture5_employee_services;
        this.lecture5_employee_repository = lecture5_employee_repository;
        this.lecture6_async_services = lecture6_async_services;
    }

    /**
     * Test entity graph
     * @param id
     * @return
     */
    @GetMapping("/test-entitygraph/{id}")
    public ResponseEntity<?> test_entitygraph(@PathVariable int id) {
        Lecture5EmployeeModel employee_data = lecture5_employee_services.get_employee_with_accounts_by_id(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee_data);
    }

    /**
     * Test pagination
     * @param page
     * @return
     */
    @GetMapping("/test-pagination/{page}")
    public ResponseEntity<?> test_pagination(@PathVariable int page) {
        Page<Lecture5EmployeeModel> employee_data = lecture5_employee_services.get_employee_with_pagination(page, 5);
        return ResponseEntity.status(HttpStatus.OK).body(employee_data);
    }

    @GetMapping("/test-async")
    public String Email (){
        lecture6_async_services.send_email("khang@gmail.com");
        return "Email sent";
    }

    @GetMapping("/test-async-report")
    public ResponseEntity<?> generate_report() throws Exception{
        CompletableFuture<String> report = lecture6_async_services.generate_report();
        return ResponseEntity.ok(report.get());
    }

}
