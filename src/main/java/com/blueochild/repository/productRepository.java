package com.blueochild.repository;

import com.blueochild.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<Product, Integer> {
}


