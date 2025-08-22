package com.example.JavaSpingBootPractice.services;

import java.util.List;
import org.springframework.stereotype.*;
import jakarta.transaction.Transactional;

import com.example.JavaSpingBootPractice.repository.*;
import com.example.JavaSpingBootPractice.model.*;

@Service
public class Lecture5AccountServices {
    private final Lecture2AccountRepository lecture2_account_repository;

    public Lecture5AccountServices(Lecture2AccountRepository lecture2_account_repository) {
        this.lecture2_account_repository = lecture2_account_repository;
    }

    @Transactional
    public List<?> tranfer_money(Integer form_id, Integer to_id, float amount) {
        Lecture2AccountModel from = lecture2_account_repository.findById(form_id).orElseThrow(() -> new RuntimeException("Account not found"));
        Lecture2AccountModel to = lecture2_account_repository.findById(to_id).orElseThrow(() -> new RuntimeException("Account not found"));
        System.out.println("Before: from=" + from.get_avail_balance() + ", to=" + to.get_avail_balance());
        from.set_avail_balance(from.get_avail_balance() - amount);
        to.set_avail_balance(to.get_avail_balance() + amount);
        lecture2_account_repository.save(from);
        lecture2_account_repository.save(to);
        System.out.println("After: from=" + from.get_avail_balance() + ", to=" + to.get_avail_balance());
        if (from.get_avail_balance() < 0) {
            throw new RuntimeException("Not enough money from " + form_id);
        }
        lecture2_account_repository.flush();
        List<?> data = lecture2_account_repository.findAll();
        return data;
    }

    public List<Lecture2AccountModel> get_all_accounts() {
        return lecture2_account_repository.findAll();
    }
    
}
