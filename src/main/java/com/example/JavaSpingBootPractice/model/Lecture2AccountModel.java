package com.example.JavaSpingBootPractice.model;

import jakarta.persistence.*;
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

    @Column(name = "open_emp_id", nullable = false)
    private int openEmpId;

    @Column(name = "product_cd", nullable = false, length = 10)
    private String productCd;

    public int getAccount_id() {
        return accountId;
    }

    public void setAccount_id(int accountId) {
        this.accountId = accountId;
    }

    public Float getAvail_balance() {
        return availBalance;
    }

    public void setAvail_balance(Float availBalance) {
        this.availBalance = availBalance;
    }

    public java.util.Date getClose_date() {
        return closeDate;
    }

    public void setClose_date(java.util.Date closeDate) {
        this.closeDate = closeDate;
    }

    public java.util.Date getLast_activity_date() {
        return lastActivityDate;
    }

    public void setLast_activity_date(java.util.Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public java.util.Date getOpen_date() {
        return openDate;
    }

    public void setOpen_date(java.util.Date openDate) {
        this.openDate = openDate;
    }

    public Float getPending_balance() {
        return pendingBalance;
    }

    public void setPending_balance(Float pendingBalance) {
        this.pendingBalance = pendingBalance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCust_id() {
        return custId;
    }

    public void setCust_id(int custId) {
        this.custId = custId;
    }

    public int getOpen_branch_id() {
        return openBranchId;
    }

    public void setOpen_branch_id(int openBranchId) {
        this.openBranchId = openBranchId;
    }

    public int getOpen_emp_id() {
        return openEmpId;
    }

    public void setOpen_emp_id(int openEmpId) {
        this.openEmpId = openEmpId;
    }

    public String getProduct_cd() {
        return productCd;
    }

    public void setProduct_cd(String product_cd) {
        this.productCd = product_cd;
    }

    @ManyToOne
    @JoinColumn(name = "cust_id")
    @JsonBackReference // Dành cho phía "con"
    private Lecture2CustomerModel customer;
}