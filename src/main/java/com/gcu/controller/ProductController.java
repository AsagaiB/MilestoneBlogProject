package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.gcu.model.Product;
import com.gcu.service.ProductService;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/product")
    public String createProduct(
            @Valid @ModelAttribute Product product,
            BindingResult result) {

        if (result.hasErrors()) {
            return "product";
        }

        productService.createProduct(product);
        return "redirect:/product";
    }
}