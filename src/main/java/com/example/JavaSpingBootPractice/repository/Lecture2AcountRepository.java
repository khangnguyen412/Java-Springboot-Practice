package com.example.JavaSpingBootPractice.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;

import com.example.JavaSpingBootPractice.model.Lecture2AccountModel;

@Repository
public interface Lecture2AcountRepository extends JpaRepository<Lecture2AccountModel, Integer> {
    List<Lecture2AccountModel> findByOpenBranchId(int openBranchId);

    @Query("SELECT a FROM Lecture2AccountModel a WHERE a.pendingBalance > :price")
    List<Lecture2AccountModel> fillterBalance(float price);

    /**
     * Chỉ lấy các cột cần truy vấn và bắt buộc phải lấy những cột not null
     */
    @Query(value = " SELECT a.account_id, a.avail_balance, a.close_date, a.last_activity_date, a.cust_id, a.open_branch_id, a.open_emp_id, a.open_date, a.status, a.pending_balance, a.product_cd, c.address, c.city FROM account a JOIN customer c ON a.cust_id = c.cust_id WHERE a.pending_balance > :price ", nativeQuery = true)
    List<Lecture2AccountModel> findByBalanceNative(long price);
}