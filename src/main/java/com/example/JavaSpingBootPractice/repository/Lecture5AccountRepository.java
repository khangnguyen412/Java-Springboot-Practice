package com.example.JavaSpingBootPractice.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;

import com.example.JavaSpingBootPractice.model.*;

@Repository
public interface Lecture5AccountRepository extends JpaRepository<Lecture2AccountModel, Integer> {
}
