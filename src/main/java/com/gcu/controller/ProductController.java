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

    // DISPLAY ALL PRODUCTS
    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    // SHOW CREATE FORM
    @GetMapping("/product")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    // SAVE PRODUCT
    @PostMapping("/product")
    public String saveProduct(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product";
        }

        productService.save(product);
        return "redirect:/products";
    }

    // DELETE PRODUCT
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/products";
    }

    // SHOW UPDATE FORM
    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "product";
    }
}