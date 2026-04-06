package com.gcu.repository;

import org.springframework.data.repository.CrudRepository;
import com.gcu.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}