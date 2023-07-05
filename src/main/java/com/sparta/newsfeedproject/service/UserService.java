package com.sparta.newsfeedproject.service;

import com.sparta.newsfeedproject.dto.UserResponseDto;
import com.sparta.newsfeedproject.entity.User;

public class UserService {

    public UserResponseDto getUser(Long id){
        User user = findUser(id);
        return new UserResponseDto(user);
    }

    private User findUser(Long id){
        return userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 정보는 존재하지 않습니다"));
    }
}
