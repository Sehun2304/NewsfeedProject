package com.sparta.newsfeedproject.service;

import com.sparta.newsfeedproject.dto.ApiResponseDto;
import com.sparta.newsfeedproject.dto.RegisterRequest;
import com.sparta.newsfeedproject.dto.UpdateRequestDto;
import com.sparta.newsfeedproject.dto.UserResponseDto;
import com.sparta.newsfeedproject.entity.User;
import com.sparta.newsfeedproject.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        UserService.userRepository = userRepository;
    }



    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User register(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setIntroduce(registerRequest.getIntroduce());
        return saveUser(user);
    }

    public User saveUser(User user) {
        return userRepository.save(user); // 저장된 유저 객체 반환
    }



    public static UserResponseDto getUser(Long id){
        User user = findUser(id);
        return new UserResponseDto(user);
    }


    public static ResponseEntity<ApiResponseDto> updateUser(Long id, UpdateRequestDto updateRequestDto) {
        return null;
    }

    private static User findUser(Long id){
        return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("잘못된 유저입니다"));
    }

}

