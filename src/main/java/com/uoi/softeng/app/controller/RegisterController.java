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

        List<String> categories = new ArrayList<>();
        categories.add("Art");
        categories.add("Comic");
        categories.add("Fantasy");
        categories.add("Fiction");
        categories.add("Biography");
        categories.add("History");
        categories.add("Science");
        categories.add("Literature");
        categories.add("Adventure");
        categories.add("Crime");
        categories.add("Other");
        model.addAttribute("categories", categories);

        return "register";
    }

    @PostMapping("/save")
    public String registerUser(@ModelAttribute("user") UserDTO userDTO, @RequestParam(value = "favCats") String[] favCats, Model model) {
        try {
            List<Category> categories = new ArrayList<>();
            for (String cat : favCats) {
                Category category = new Category(cat);
                categories.add(category);
            }
            System.out.println(categories.getFirst().getCategoryName());
            userDTO.setFavouriteCategories(categories);
//            System.out.println(userDTO.favouriteCategories.size() + "\t" + userDTO.favouriteCategories.get(0).getCategoryName());
            userService.registerUser(userDTO);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/register";
        }
    }
}
