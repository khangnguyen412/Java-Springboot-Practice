package com.example.JavaSpingBootPractice.services;

import java.util.*;

import org.springframework.stereotype.Service;
import com.example.JavaSpingBootPractice.repository.*;
import com.example.JavaSpingBootPractice.model.*;

@Service
public class Lecture2Services {
    private final Lecture2AcountRepository lecture2_account_repository;

    public Lecture2Services(Lecture2AcountRepository lecture2_account_repository) {
        this.lecture2_account_repository = lecture2_account_repository;
    }

    /**
     * Get account by id
     */
    public List<Lecture2Model> get_all_account() {
        return lecture2_account_repository.findAll();
    }

    /**
     * Create a new account
     */
    public Lecture2Model create_account(Lecture2Model account) {
        return lecture2_account_repository.save(account);
    }
}