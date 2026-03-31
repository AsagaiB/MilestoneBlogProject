package com.gcu.controller;

import com.gcu.model.Product;
import com.gcu.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    // 🔹 Show product creation page
    @GetMapping("/product")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    // 🔹 Handle form submission
    @PostMapping("/product")
    public String createProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult result,
                                Model model) {

        // If validation fails → stay on page
        if (result.hasErrors()) {
            return "product";
        }

        // Save to database
        productService.createProduct(product);

        // Optional success message
        model.addAttribute("message", "Product created successfully!");

        return "product"; // or "redirect:/product"
    }
}