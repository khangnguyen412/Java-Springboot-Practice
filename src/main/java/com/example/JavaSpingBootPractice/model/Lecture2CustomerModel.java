package com.example.JavaSpingBootPractice.model;

import java.util.*;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "customer")
/**
 * Có thể dùng @NamedQueries({}) để tạo các nhóm @NamedQuery
 * :custId trong @NamedQuery phải là tên Entity class chứ ko phải tên bảng
 */
@NamedQuery(name = "Lecture2CustomerModel.find_by_id", query = "SELECT c FROM Lecture2CustomerModel c where c.custId = :custId")
@NamedQuery(name = "Lecture2CustomerModel.find_by_city", query = "SELECT c FROM Lecture2CustomerModel c where c.custId = :city")
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

    /**
     * Set property
     */

    public void set_cust_id(int custId) {
        this.custId = custId;
    }

    public void set_address(String address) {
        this.address = address;
    }

    public void set_city(String city) {
        this.city = city;
    }

    public void set_cust_type_cd(String custTypeCd) {
        this.custTypeCd = custTypeCd;
    }

    public void set_fed_id(String fedId) {
        this.fedId = fedId;
    }

    public void set_postal_code(String postalCode) {
        this.postalCode = postalCode;
    }

    public void set_state(String state) {
        this.state = state;
    }

    /**
     * Get property
     */
    public int get_cust_id() {
        return custId;
    }

    public String get_address() {
        return address;
    }

    public String get_city() {
        return city;
    }

    public String get_cust_type_cd() {
        return custTypeCd;
    }

    public String get_fed_id() {
        return fedId;
    }

    public String get_postal_code() {
        return postalCode;
    }

    public String get_state() {
        return state;
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Dành cho phía "cha"
    private List<Lecture2AccountModel> accounts;
}