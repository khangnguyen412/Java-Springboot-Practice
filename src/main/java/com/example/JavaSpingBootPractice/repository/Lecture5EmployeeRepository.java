package com.example.JavaSpingBootPractice.repository;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.data.domain.*;


import com.example.JavaSpingBootPractice.model.*;

@Repository
public interface Lecture5EmployeeRepository extends JpaRepository<Lecture5EmployeeModel, Integer> {
    Page<Lecture5EmployeeModel> findAll(Pageable pageable);
    
    @Query("SELECT e FROM Lecture5EmployeeModel e WHERE e.empId = :id")
    Lecture5EmployeeModel findByIdSimple(@Param("id") int id);

    @Query("SELECT e FROM Lecture5EmployeeModel e JOIN FETCH e.accounts WHERE e.empId = :id")
    Lecture5EmployeeModel findByIdWithAccounts(@Param("id") int id);
}