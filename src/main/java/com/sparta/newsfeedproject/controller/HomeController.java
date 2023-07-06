package com.sparta.newsfeedproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @GetMapping("/")
    public String index() {
        return "index";
    }
}