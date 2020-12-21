package com.blueochild.repository;

import com.blueochild.datamodel.SaleGroupByUserId;
import com.blueochild.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
    public List<Sale> findByUserId(int userId);

    @Query(value =
            "SELECT USER_ID as userId, SUM(PAID_PRICE) as totalPaidPrice " +
            "FROM SALE WHERE user_Id = ?1 GROUP BY user_Id",
            nativeQuery = true)
    public SaleGroupByUserId PurchaseAmountGroupByUserId(int userId);
}
