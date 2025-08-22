package com.example.JavaSpingBootPractice.services;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.JavaSpingBootPractice.repository.*;
import com.example.JavaSpingBootPractice.model.*;

@Service
public class Lecture2AccountServices {
    private final Logger logger = LoggerFactory.getLogger(Lecture2AccountServices.class);
    private final Lecture2AccountRepository lecture2_account_repository;

    public Lecture2AccountServices(Lecture2AccountRepository lecture2_account_repository) {
        this.lecture2_account_repository = lecture2_account_repository;
    }

    /**
     * Get account by id
     */
    public List<Lecture2AccountModel> get_all_account() {
        logger.info("get all account");
        return lecture2_account_repository.findAll();
    }

    /**
     * Create a new account
     */
    public Lecture2AccountModel create_account(Lecture2AccountModel account) {
        return lecture2_account_repository.save(account);
    }

    /**
     * - Sử dụng cho custom query nếu cần thiết
     * - Và chỉ sử dụng khi có query phức tạp
     */
    public List<Lecture2AccountModel> fillterBalance(float price) {
        return lecture2_account_repository.fillterBalance(price);
    }  
    
    public List<Lecture2AccountModel> findByBalanceNative(long price) {
        return lecture2_account_repository.findByBalanceNative(price);
    }

}