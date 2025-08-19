package com.example.JavaSpingBootPractice.model;

import java.util.*;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "customer")
public class Lecture2CustomerModel {
    @Id
    @Column(name = "cust_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "city", nullable = true)
    private String city;

    @Column(name = "cust_type_cd", nullable = true)
    private String custTypeCd;

    @Column(name = "fed_id", nullable = true)
    private String fedId;

    @Column(name = "postal_code", nullable = true)
    private String postalCode;

    @Column(name = "state", nullable = true)
    private String state;

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getCustId() {
        return custId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCustTypeCd(String custTypeCd) {
        this.custTypeCd = custTypeCd;
    }

    public String getCustTypeCd() {
        return custTypeCd;
    }

    public void setFedId(String fedId) {
        this.fedId = fedId;
    }

    public String getFedId() {
        return fedId;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Dành cho phía "cha"
    private List<Lecture2AccountModel> accounts;
}