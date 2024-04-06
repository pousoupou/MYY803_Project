package com.uoi.softeng.app.controller;


import com.uoi.softeng.app.dto.UserDTO;
import com.uoi.softeng.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }


    @PostMapping("/register")
    public void registerUser(@ModelAttribute UserDTO userDTO) {
        // Register the user
        userService.registerUser(userDTO);

    }
}
