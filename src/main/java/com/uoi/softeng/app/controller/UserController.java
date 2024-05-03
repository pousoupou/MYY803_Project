package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.dto.UserDTO;
import com.uoi.softeng.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
