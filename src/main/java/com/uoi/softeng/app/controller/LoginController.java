//package com.uoi.softeng.app.controller;
//
//import com.uoi.softeng.app.dto.LoginDTO;
//import com.uoi.softeng.app.model.User;
//import com.uoi.softeng.app.services.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.concurrent.CompletableFuture;
//
//@Controller
//@RequestMapping("/")
//public class LoginController {
//    @Autowired
//    IUserService userService;
//
//    @Autowired
//    private BCryptPasswordEncoder encoder;
//
//    @GetMapping("login")
//    public String loginPage(Model model){
//        model.addAttribute("loginDTO", new LoginDTO());
//        return "login";
//    }
//
//    @RequestMapping("login")
//    public String loginUser(@ModelAttribute("loginDTO") LoginDTO loginDTO, Model model){
//        if(encoder.matches(loginDTO.getPassword(), userService.getUserByEmail(loginDTO.getEmail()).getPassword())){
//            User user = userService.getUserByEmail(loginDTO.getEmail());
//            model.addAttribute("user", user);
//
//            return "redirect:/dashboard";
//        }
//
//        return "redirect:/error";
//    }
//
//






//
//
//
//
//
//
//
//}