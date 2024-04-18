package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.dto.UserDTO;
import com.uoi.softeng.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/save")
    public String registerUser(@ModelAttribute("user") UserDTO userDTO, Model model) {
        try {
            // Register the user
            userService.registerUser(userDTO);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/register";
        }
    }
}
