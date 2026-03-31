package com.gcu.controller;

import com.gcu.model.User;
import com.gcu.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model) {

        User validUser = userService.login(user.getUsername(), user.getPassword());

        if (validUser != null) {
            return "index";
        }

        model.addAttribute("error", "Invalid login");
        return "login";
    }
}