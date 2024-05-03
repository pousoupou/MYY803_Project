package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.dto.LoginDTO;
import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    IUserService userService;

//    @RequestMapping("/home")
//    public String home(){
//        return "home";
//    }

    @RequestMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

//    @RequestMapping("/save")
//    public String registerUser(@ModelAttribute("user") User user, Model model){
//
//        if(userService.isUserPresent(user)){
//            model.addAttribute("successMessage", "User already registered!");
//            return "login";
//        }
//
////        userService.(user);
//        model.addAttribute("successMessage", "User registered successfully!");
//
//        return "login";
//    }
}
