package com.sparta.newsfeedproject.controller;

import com.sparta.newsfeedproject.dto.PasswordUpdateRequestDto;
import com.sparta.newsfeedproject.dto.ProfileUpdateRequestDto;
import com.sparta.newsfeedproject.dto.UserResponseDto;
import com.sparta.newsfeedproject.security.UserDetailsImpl;
import com.sparta.newsfeedproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final UserService userService;


    //프로필 가져오기
    @GetMapping("/")
    public UserResponseDto viewUser(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return userService.viewUser(userDetails);
    }

    //프로필 수정
    @PatchMapping("/edit/intro")
    public UserResponseDto updateUser(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody ProfileUpdateRequestDto profileUpdateRequestDto) {
        userService.updateUser(userDetails, profileUpdateRequestDto);
        return userService.viewUser(userDetails);
    }

    //비밀번호 변경
    @PatchMapping("/edit/password")
    public UserResponseDto updatePass(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody PasswordUpdateRequestDto passwordUpdateRequestDto) {
        userService.updatePassword(userDetails, passwordUpdateRequestDto);
        return userService.viewUser(userDetails);
    }
}








