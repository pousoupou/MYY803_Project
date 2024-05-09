package com.uoi.softeng.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Add any attributes to the model that you want to access in the dashboard view
        // ...

        return "dashboard"; // This should be the name of your Thymeleaf dashboard template (without .html)
    }
}