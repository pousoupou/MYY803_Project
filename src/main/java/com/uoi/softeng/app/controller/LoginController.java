package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.dto.LoginDTO;
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

    @RequestMapping("/login")
    public String loginUser(@ModelAttribute("loginDTO") LoginDTO loginDTO){
        if(encoder.matches(loginDTO.getPassword(), userService.getUserByEmail(loginDTO.getEmail()).getPassword())){
            return "redirect:/hello";
        }

        return "redirect:/error";
    }
}