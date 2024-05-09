package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.dto.UserDTO;
import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/add")
    public @ResponseBody String addUserData(@RequestBody UserDTO userDTO){
        userService.registerUser(userDTO);

        return "ADDED";
    }

    @GetMapping("/get")
    public @ResponseBody List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/update/{uuid}")
    public @ResponseBody String updateUserData(@PathVariable("uuid") String uuid, @RequestBody UserDTO userDTO){
        userService.updateUser(uuid, userDTO);

        return "UPDATED";
    }

    @DeleteMapping("/delete/{uuid}")
    public @ResponseBody String deleteUser(@PathVariable("uuid") String uuid){
        userService.deleteUser(uuid);

        return "DELETED";
    }
}
