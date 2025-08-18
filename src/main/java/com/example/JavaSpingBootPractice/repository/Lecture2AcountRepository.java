package com.example.JavaSpingBootPractice.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JavaSpingBootPractice.model.Lecture2Model;

@Repository
public interface Lecture2AcountRepository extends JpaRepository<Lecture2Model, Integer> {
    /**
     * Sử dụng cho custom query nếu cần thiết
     * @return
     */
    List<Lecture2Model> findByOpenBranchId(int openBranchId);
}