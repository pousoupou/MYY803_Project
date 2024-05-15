package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(Model model) {
        // Implement login logic here
        return "login";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        userService.register(user);
        return "redirect:/auth/login";
    }
}
