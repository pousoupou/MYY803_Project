package com.uoi.softeng.app.controller;

import com.uoi.softeng.app.services.UserProfileService;
import com.uoi.softeng.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserProfileService userProfileService;



    @GetMapping("/books")
    public String listBookOffers(Model model) {
        // List book offers and add to model
        return "bookOffers";
    }

    @GetMapping("/offer")
    public String showOfferForm(Model model) {
        // Show form to offer a book
        return "offerForm";
    }

    @PostMapping("/offer/save")
    public <BookFormData> String saveOffer(@ModelAttribute BookFormData BookFormData, Model model) {
        userService.saveBookOffer(BookFormData);
        return "redirect:/user/books";
    }

    @GetMapping("/search")
    public String showSearchForm(Model model) {
        // Show search form
        return "searchForm";
    }

    @PostMapping("/search/results")
    public <SearchFormData> String search(@ModelAttribute SearchFormData searchFormData, Model model) {
        // Perform search and add results to model
        return "searchResults";
    }

    @GetMapping("/recommendations")
    public String showRecommendationsForm(Model model) {
        // Show recommendations form
        return "recommendationsForm";
    }

//    @PostMapping("/recommend")
//    public String recommendBooks(@ModelAttribute RecommendationsFormData recomFormData, Model model) {
//        // Recommend books and add to model
//        return "redirect:/user/recommendations";
//    }

    @PostMapping("/request")
    public String requestBook(@RequestParam int bookId, Model model) {
        userService.requestBook(bookId);
        return "redirect:/user/books";
    }

    @GetMapping("/requests")
    public String showBookRequests(Model model) {
        // Show book requests and add to model
        return "bookRequests";
    }

    @GetMapping("/requests/users")
    public String showRequestingUsersForBook(@RequestParam int bookId, Model model) {
        // Show users requesting a particular book
        return "requestingUsers";
    }

    @PostMapping("/request/accept")
    public String acceptRequest(@RequestParam String username, @RequestParam int bookId, Model model) {
        userService.acceptBookRequest(username, bookId);
        return "redirect:/user/requests";
    }

    @PostMapping("/request/delete")
    public String deleteBookRequest(@RequestParam String username, @RequestParam int bookId, Model model) {
        userService.deleteBookRequest(username, bookId);
        return "redirect:/user/requests";
    }
}
