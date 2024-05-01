package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.dto.LoginDTO;
import com.uoi.softeng.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public String loginPage(Model model){
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @PostMapping
    public String loginUser(@ModelAttribute("loginDTO") LoginDTO loginDTO){
        String uuid = userService.userLogin(loginDTO);

        if(uuid != null){
            return "redirect:/home";
        } else {
            return "login";
        }
    }
}