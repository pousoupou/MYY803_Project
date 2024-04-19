package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.dto.UserDTO;
import com.uoi.softeng.app.model.Category;
import com.uoi.softeng.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserDTO());

        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Art"));
        categories.add(new Category("Comic"));
        categories.add(new Category("Fantasy"));
        categories.add(new Category("Fiction"));
        categories.add(new Category("Biography"));
        categories.add(new Category("History"));
        categories.add(new Category("Science"));
        categories.add(new Category("Literature"));
        categories.add(new Category("Adventure"));
        categories.add(new Category("Crime"));
        categories.add(new Category("Other"));
        model.addAttribute("categories", categories);

        return "register";
    }

    @PostMapping("/save")
    public String registerUser(@ModelAttribute("user") UserDTO userDTO, @RequestParam(value = "favCats", defaultValue = "") List<Category> favCats, Model model) {
        try {
            System.out.println(favCats.getFirst().getCategoryName());
            userDTO.setFavouriteCategories(favCats);
//            System.out.println(userDTO.favouriteCategories.size() + "\t" + userDTO.favouriteCategories.get(0).getCategoryName());
            userService.registerUser(userDTO);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/register";
        }
    }
}
