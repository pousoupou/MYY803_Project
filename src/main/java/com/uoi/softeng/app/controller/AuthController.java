package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.model.UserProfile;
import com.uoi.softeng.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "register";
    }

    @RequestMapping("/save")
    public String save(@ModelAttribute User user, Model model) {
        userService.register(user);
        return "redirect:/login";
    }
}
