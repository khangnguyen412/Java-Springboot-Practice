package com.example.JavaSpingBootPractice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import jakarta.transaction.Transactional;

import com.example.JavaSpingBootPractice.model.Lecture5EmployeeModel;
import com.example.JavaSpingBootPractice.repository.Lecture5EmployeeRepository;

public class Lecture5TestJPA {
    @Autowired
    private MockMvc mockMvc;
    private Lecture5EmployeeRepository Lecture5EmployeeRepository;

    @Test
    @Transactional
    public void testLazyLoading() {
        Lecture5EmployeeModel emp = Lecture5EmployeeRepository.findByIdSimple(1);
        System.out.println("Employee name: " + emp.getFirstName());

        // Khi này accounts chưa được load, SQL chưa chạy
        System.out.println("Accounts size: " + emp.getAccounts().size());
        // Lúc này Hibernate mới query accounts nếu fetch = LAZY
    }

    @Test
    @Transactional
    public void testEagerLoading() {
        Lecture5EmployeeModel emp = Lecture5EmployeeRepository.findByIdSimple(1);
        System.out.println("Employee name: " + emp.getFirstName());

        // Với EAGER, accounts đã được load rồi
        System.out.println("Accounts size: " + emp.getAccounts().size());
    }
}
