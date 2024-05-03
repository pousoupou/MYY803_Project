package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.dto.LoginDTO;
import com.uoi.softeng.app.dto.UserDTO;

import com.uoi.softeng.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/add")
    public String addUserData(Model model){
        model.addAttribute("userDTO", new UserDTO());

        return "addUser";
    }

    @PostMapping("/add")
    public String addUserData(@ModelAttribute UserDTO userDTO){
        userService.registerUser(userDTO);

        return "redirect:/user/add";
    }

    @GetMapping("/update/{uuid}")
    public String updateUserData(@PathVariable("uuid") String uuid, Model model){
        UserDTO userDTO = userService.getUser(uuid);
        model.addAttribute("userDTO", userDTO);
        return "updateUser";
    }

    @PostMapping("/update/{uuid}")
    public String updateUserData(@PathVariable("uuid") String uuid, @ModelAttribute UserDTO userDTO){
        userService.updateUser(uuid, userDTO);
        return "redirect:/user/update/" + uuid;
    }

    @GetMapping("/delete/{uuid}")
    public String deleteUser(@PathVariable("uuid") String uuid){
        userService.deleteUser(uuid);
        return "redirect:/user/list";
    }

//    @GetMapping("/login")
//    public String login(Model model){
//        model.addAttribute("loginDTO", new LoginDTO());
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute LoginDTO loginDTO, Model model){
//        String uuid = userService.userLogin(loginDTO);
//
//        if(uuid != null){
//            model.addAttribute("uuid", uuid);
//            return "redirect:/user/home";
//        } else {
//            model.addAttribute("error", "Wrong email or password");
//            return "login";
//        }
//    }


}
