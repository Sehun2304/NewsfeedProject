package com.sparta.newsfeedproject.controller;

import com.sparta.newsfeedproject.dto.ApiResponseDto;
import com.sparta.newsfeedproject.dto.UpdateRequestDto;
import com.sparta.newsfeedproject.dto.UserResponseDto;
import com.sparta.newsfeedproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor


public class ProfileController {

    private final UserService userService;


    //프로필 가져오기
    @GetMapping("/{id}")
    public UserResponseDto viewUser(@PathVariable Long id){

        return userService.viewUser(id);
    }
    //프로필 수정
    @PatchMapping("/{id}/intro")
    public ResponseEntity<ApiResponseDto> updateUser(@PathVariable Long id, @RequestBody UpdateRequestDto updateRequestDto){
        return userService.updateUser(id, updateRequestDto);
    }

    //비밀번호 수정

    @PatchMapping("/{id}/pass")
    public ResponseEntity<ApiResponseDto> updatePass(@PathVariable Long id,@RequestBody UpdateRequestDto updateRequestDto){

        return  userService.updatePass(id, updateRequestDto);
    }
    }








