package com.sparta.newsfeedproject.service;

import com.sparta.newsfeedproject.dto.RegisterRequest;
import com.sparta.newsfeedproject.entity.User;
import com.sparta.newsfeedproject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User register(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        return userRepository.save(user);
    }
}

