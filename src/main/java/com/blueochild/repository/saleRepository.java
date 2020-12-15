package com.blueochild.repository;

import com.blueochild.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface saleRepository extends JpaRepository<Sale, Integer> {
}


