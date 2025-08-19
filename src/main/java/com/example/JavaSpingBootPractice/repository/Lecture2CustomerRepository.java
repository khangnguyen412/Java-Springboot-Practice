package com.example.JavaSpingBootPractice.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;

import com.example.JavaSpingBootPractice.model.*;

@Repository
public interface Lecture2CustomerRepository extends JpaRepository<Lecture2CustomerModel, Integer> {
    /**
     * Gọi theo của private List<Lecture2AccountModel> accounts; trong model
     */
    @EntityGraph(attributePaths = { "accounts" })
    List<Lecture2CustomerModel> findAll();
}