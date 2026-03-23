package com.gcu.service;

import org.springframework.stereotype.Service;
import com.gcu.model.Product;

@Service
public class ProductService {

    public void createProduct(Product product) {
        System.out.println("Created Product: " + product.getName());
    }
}