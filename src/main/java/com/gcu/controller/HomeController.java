package com.gcu.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        model.addAttribute("loggedInUser",
                session.getAttribute("loggedInUser"));
        return "index";
    }

    @GetMapping("/products")
    public String product(HttpSession session, Model model) {
        Object user = session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("username", user);
        return "product";
    }
}