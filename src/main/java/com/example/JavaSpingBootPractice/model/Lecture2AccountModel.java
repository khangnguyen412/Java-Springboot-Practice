package com.example.JavaSpingBootPractice.model;

import jakarta.persistence.*;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "account")
public class Lecture2AccountModel {
    /**
     * @Id là khóa chính
     * @GeneratedValue tự động tăng
     */
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Column(name = "avail_balance", nullable = true)
    private Float availBalance;

    @Column(name = "close_date", nullable = true)
    private java.util.Date closeDate;

    @Column(name = "last_activity_date", nullable = true)
    private java.util.Date lastActivityDate;

    @Column(name = "open_date", nullable = false)
    private java.util.Date openDate;

    @Column(name = "pending_balance", nullable = true)
    private Float pendingBalance;

    @Column(name = "status", nullable = true)
    private String status;

    @Column(name = "cust_id", nullable = true, insertable = false, updatable = false)
    private int custId;

    @Column(name = "open_branch_id", nullable = false)
    private int openBranchId;

    @Column(name = "open_emp_id", nullable = false, insertable = false, updatable = false)
    private int openEmpId;

    @Column(name = "product_cd", nullable = false, length = 10)
    private String productCd;

    /**
    * Sử dụng @Formula để tính toán giá trị của field totalBalance
    */
    @Formula("avail_balance + pending_balance")
    @JsonProperty("total_balance") // setup định dạng formula
    private float totalBalance;

    /**
     * Set property
     */
    public void set_account_id(int accountId) {
        this.accountId = accountId;
    }

    public void set_avail_balance(Float availBalance) {
        this.availBalance = availBalance;
    }

    public void set_close_date(java.util.Date closeDate) {
        this.closeDate = closeDate;
    }

    public void set_cust_id(int custId) {
        this.custId = custId;
    }

    public void set_last_activity_date(java.util.Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public void set_open_branch_id(int openBranchId) {
        this.openBranchId = openBranchId;
    }

    public void set_open_date(java.util.Date openDate) {
        this.openDate = openDate;
    }

    public void set_open_emp_id(int openEmpId) {
        this.openEmpId = openEmpId;
    }

    public void set_pending_balance(Float pendingBalance) {
        this.pendingBalance = pendingBalance;
    }

    public void set_product_cd(String product_cd) {
        this.productCd = product_cd;
    }

    public void set_status(String status) {
        this.status = status;
    }

    /**
     * Get property
     */

    public int get_account_id() {
        return accountId;
    }

    public Float get_avail_balance() {
        return availBalance;
    }

    public java.util.Date get_close_date() {
        return closeDate;
    }

    public java.util.Date get_last_activity_date() {
        return lastActivityDate;
    }

    public int get_cust_id() {
        return custId;
    }

    public int get_open_branch_id() {
        return openBranchId;
    }

    public java.util.Date get_open_date() {
        return openDate;
    }

    public int get_open_emp_id() {
        return openEmpId;
    }

    public Float get_pending_balance() {
        return pendingBalance;
    }

    public String get_product_cd() {
        return productCd;
    }

    public String get_status() {
        return status;
    }

    public float get_total_balance() {
        return totalBalance;
    }

    @ManyToOne
    @JoinColumn(name = "cust_id")
    @JsonBackReference // Dành cho phía "con"
    private Lecture2CustomerModel customer;

    @ManyToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name = "open_emp_id")
    @JsonBackReference // Dành cho phía "con"
    private Lecture5EmployeeModel employee;
}