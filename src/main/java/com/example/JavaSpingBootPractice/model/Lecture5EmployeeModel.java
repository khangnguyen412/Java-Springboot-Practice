package com.example.JavaSpingBootPractice.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CacheConcurrencyStrategy;    
import org.hibernate.annotations.Formula;
import jakarta.persistence.*;


@Entity
@Table(name = "employee")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Lecture5EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Formula("concat(first_name, ' ', last_name)")
    private String fullName;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "title", nullable = true, length = 20)
    private String title;

    @Column(name = "assigned_branch_id", nullable = true)
    private int assignedBranchId;

    @Column(name = "dept_id", nullable = true)
    private int deptId;

    @Column(name = "superior_emp_id")
    private Integer superiorEmpId;

    /**
     * Set property 
     * 
     */
    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public void setFullName(String full_name) {
        this.fullName = full_name;
    }

    public void setStartDate(Date start_date) {
        this.startDate = start_date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAssignedBranchId(int assigned_branch_id) {
        this.assignedBranchId = assigned_branch_id;
    }

    public void setDeptId(int dept_id) {
        this.deptId = dept_id;
    }

    public void setSuperiorEmpId(int superior_emp_id) {
        this.superiorEmpId = superior_emp_id;
    }

    /**
     * Get property 
     */
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getTitle() {
        return title;
    }

    public int getAssignedBranchId() {
        return assignedBranchId;
    }

    public int getDeptId() {
        return deptId;
    }

    public Integer getSuperiorEmpId() {
        return superiorEmpId;
    }

    public List<Lecture2AccountModel> getAccounts() {
        return accounts;
    }

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Lecture2AccountModel> accounts;
}