package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.model.Product;
import com.gcu.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void createProduct(Product product) {
        productRepository.save(product);
    }
}