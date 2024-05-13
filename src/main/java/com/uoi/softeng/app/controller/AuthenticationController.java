package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthenticationController {

    @Autowired
    UserService userService;


    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);


    @RequestMapping("/signin")
    public String login(){
        //model.addAttribute("loginDTO", new LoginDTO());
        return "auth/login";
    }

    @RequestMapping("/signup")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "auth/register";
    }

//    @GetMapping("/register")
//    public String registerPage(Model model) {
//        model.addAttribute("user", new UserDTO());
//
//        List<String> categories = new ArrayList<>();
//        categories.add("Art");
//        categories.add("Comic");
//        categories.add("Fantasy");
//        categories.add("Fiction");
//        categories.add("Biography");
//        categories.add("History");
//        categories.add("Science");
//        categories.add("Literature");
//        categories.add("Adventure");
//        categories.add("Crime");
//        categories.add("Other");
//        model.addAttribute("categories", categories);
//
//        return "register";
//    }


    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        logger.info("Attempting to save user: {}", user);

        if(userService.isUserPresent(user)){
            logger.info("User already registered: {}", user);
            model.addAttribute("successMessage", "User already registered!");
            return "auth/login";
        }

        userService.saveUser(user);
        logger.info("User registered successfully: {}", user);
        model.addAttribute("successMessage", "User registered successfully!");

        return "auth/login";
    }

}
