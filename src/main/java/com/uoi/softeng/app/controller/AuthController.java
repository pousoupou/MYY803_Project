package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.model.Role;
import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.model.UserProfile;
import com.uoi.softeng.app.services.UserProfileService;
import com.uoi.softeng.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder encoder;

    @RequestMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "login";
    }

    @RequestMapping("/loginAction")
    public String loginAction(@ModelAttribute User user, Model model) {
        String password = user.getPassword();

        if(!userService.isUserPresent(user)){
            throw new UsernameNotFoundException("User not found");
        } else if(encoder.matches(password, userService.findByEmail(user.getUsername()).getPassword())) {
            return "redirect:/user/profile";
        } else {
            throw new RuntimeException("Wrong password");
        }
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
        return "redirect:/auth/login";
    }
}
