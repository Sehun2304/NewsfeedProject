package com.sparta.newsfeedproject.controller;

import com.sparta.newsfeedproject.dto.RegisterRequest;
import com.sparta.newsfeedproject.entity.User;
import com.sparta.newsfeedproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest) {
        User user = userService.register(registerRequest);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/login-page")
    public String loginPage() {
        return "login";
    }
}

