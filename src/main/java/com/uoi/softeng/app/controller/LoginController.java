package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.dto.LoginDTO;
import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    IUserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @RequestMapping("")
    public String loginPage(Model model){
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("loginDTO") LoginDTO loginDTO, Model model){
        if(encoder.matches(loginDTO.getPassword(), userService.getUserByEmail(loginDTO.getEmail()).getPassword())){
            User user = userService.getUserByEmail(loginDTO.getEmail());
            model.addAttribute("user", user);

            System.out.println("\n\nuser\n\n");

            return "redirect:/user/home";
        }

        return "redirect:/error";
    }
}