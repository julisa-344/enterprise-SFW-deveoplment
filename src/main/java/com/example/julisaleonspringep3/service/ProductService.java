package com.example.julisaleonspringep3.service;

import com.example.julisaleonspringep3.model.Product;
import com.example.julisaleonspringep3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> searchByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}