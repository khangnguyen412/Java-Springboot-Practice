package com.example.JavaSpingBootPractice.services;

import java.util.*;
import org.springframework.stereotype.Service;

import com.example.JavaSpingBootPractice.repository.*;
import com.example.JavaSpingBootPractice.model.*;
import com.example.JavaSpingBootPractice.dto.*;
import com.example.JavaSpingBootPractice.exception.CustomerNotFoundException;

@Service
public class Lecture2CustomerServices {
    private final Lecture2CustomerRepository lecture2_customer_repository;

    public Lecture2CustomerServices(Lecture2CustomerRepository lecture2_customer_repository) {
        this.lecture2_customer_repository = lecture2_customer_repository;
    }

    /**
     * Get account by id
     */
    public List<Lecture2CustomerModel> get_all_customers() {
        List<Lecture2CustomerModel> data = lecture2_customer_repository.findAll();
        if (data.isEmpty()) {
            throw new CustomerNotFoundException("Không tìm thấy khách hàng");
        }
        return data;
    }

    /**
     * Create a new account
     */
    public Lecture2CustomerModel add_customer(Lecture3CustomerDTO account) {
        Lecture2CustomerModel data = new Lecture2CustomerModel();
        data.setAddress(account.getAddress());
        data.setCity(account.getCity());
        data.setCustTypeCd(account.getCust_type_cd());
        data.setFedId(account.getFed_id());
        data.setPostalCode(account.getPostal_code());
        data.setState(account.getState());
        return lecture2_customer_repository.save(data);
    }
}