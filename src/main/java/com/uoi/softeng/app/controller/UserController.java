package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.entity.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {

    @RequestMapping("/show_form")
    public String showForm(Model model) {
        UserData userData = new UserData();
        model.addAttribute("user_data", userData);


        return "register";
    }

    @RequestMapping("/register")
    public String registerUser(@ModelAttribute("user_data")UserData userData) {
        return "user/register_success";
    }


    @RequestMapping("/user/dashboard")
    public String getUserHome(){
//    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		 String currentPrincipalName = authentication.getName();
//		 System.err.println(currentPrincipalName);

        return "user/dashboard";
    }

}
