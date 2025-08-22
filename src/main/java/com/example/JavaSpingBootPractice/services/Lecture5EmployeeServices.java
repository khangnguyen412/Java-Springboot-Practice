package com.example.JavaSpingBootPractice.services;

import java.util.List;
import org.springframework.stereotype.*;
import jakarta.transaction.Transactional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.example.JavaSpingBootPractice.repository.*;
import com.example.JavaSpingBootPractice.model.*;

@Service
public class Lecture5EmployeeServices {
    private final Lecture5EmployeeRepository lecture5_employee_repository;

    public Lecture5EmployeeServices(Lecture5EmployeeRepository lecture5_employee_repository) {
        this.lecture5_employee_repository = lecture5_employee_repository;
    }

    /**
     * Lưu cache khi query theo id
     */
    @Cacheable(value = "lecture5_employee", key = "#id")
    public Lecture5EmployeeModel get_employee_by_id(int id) {
        return lecture5_employee_repository.findById(id).orElse(null);
    }

    /**
     * Lưu cache sau khi update
     */
    @CacheEvict(value = "lecture5_employee", key = "#id")
    public Lecture5EmployeeModel update_employee_first_name(int id, String new_first_name) {
        Lecture5EmployeeModel user_data = lecture5_employee_repository.findById(id).orElse(null);
        user_data.setFirstName(new_first_name);
        lecture5_employee_repository.save(user_data);
        return lecture5_employee_repository.findByIdWithAccounts(id);
    }
}
