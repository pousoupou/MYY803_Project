package com.uoi.softeng.app.controller;



import com.uoi.softeng.app.dto.UserDTO;
import com.uoi.softeng.app.repository.UserRepository;
import com.uoi.softeng.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public RegisterController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }


    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserDTO userDTO, Model model) {
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
