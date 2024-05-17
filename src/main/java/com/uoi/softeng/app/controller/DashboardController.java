package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class DashboardController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);

        Optional<User> user = userRepository.findByUsername(currentPrincipalName);
        model.addAttribute("user", user);

        return "dashboard";
    }
}