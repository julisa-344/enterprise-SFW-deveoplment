package com.example.julisaleonspringep3.repository;

import com.example.julisaleonspringep3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Additional query methods can be defined here if needed
}