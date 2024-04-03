package com.uoi.softeng.app.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@Slf4j
public class MainController {
    @RequestMapping({"/" , "/temp.html"})
    public String root() {
        return "temp.html";
    }

    /** Home page. */
    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }

    /** User zone index. */
    @RequestMapping("/user/index.html")
    public String userIndex() {
        return "user/index";
    }

    /** Administration zone index. */
    @RequestMapping("/admin/index.html")
    public String adminIndex() {
        return "admin/index";
    }

    /** Shared zone index. */
    @RequestMapping("/shared/index.html")
    public String sharedIndex() {
        return "shared/index";
    }

    /** Login form. */
    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }
}
