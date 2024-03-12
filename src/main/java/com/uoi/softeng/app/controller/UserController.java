package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.dto.UserDTO;
import com.uoi.softeng.app.model.User;
import com.uoi.softeng.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/get/{permission}/{id}")
    public @ResponseBody User getUserData(@PathVariable("permission") Boolean perm, @PathVariable("id") Integer id){
        if(perm){
            Optional<User> optUser = userRepo.findById(id);

            return optUser.get().omitPrivateData();
        } else {
            return null;
        }
    }

    @PostMapping("/add")
    public @ResponseBody String addUserData(@RequestBody UserDTO userDTO){
        User user = new User(userDTO);
        userRepo.save(user);

        return "ADDED";
    }

    @PutMapping("/update/{id}")
    public @ResponseBody String updateUserData(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO){
        User user = userRepo.findUserByEmail(userDTO.email);

        user.updateUserData(userDTO);
        userRepo.save(user);

        return "UPDATED";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id){
        userRepo.deleteById(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
