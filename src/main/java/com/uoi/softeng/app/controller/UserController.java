package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.dto.PrivateUserDTO;
import com.uoi.softeng.app.dto.PublicUserDTO;
import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/get/{permission}/{id}")
    public @ResponseBody User getUserData(@PathVariable("permission") Boolean perm, @PathVariable("id") Integer id){
        Optional<User> publicUser = userRepo.findById(id);

        if(perm){
            PrivateUserDTO privateData = new PrivateUserDTO(publicUser.get());

            return new User(privateData);
        } else {
            return publicUser.get();
        }
    }

    @PostMapping("/add")
    public @ResponseBody String addUserData(@RequestBody PublicUserDTO publicUserDTO){
        User user = new User(publicUserDTO);
        userRepo.save(user);

        return "SUCCESS";
    }
}
