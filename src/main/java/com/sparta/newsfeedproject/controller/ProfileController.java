package com.sparta.newsfeedproject.controller;

import com.sparta.newsfeedproject.dto.ApiResponseDto;
import com.sparta.newsfeedproject.dto.PassUpdateDto;
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


    //프로필 가져오기
    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable Long id){
        return UserService.getUser(id);
    }
    //프로필 수정
    @PatchMapping("/{id}/intro")
    public ResponseEntity<ApiResponseDto> updateUser(@PathVariable Long id, @RequestBody UpdateRequestDto updateRequestDto){
        return UserService.updateUser(id, updateRequestDto);
    }

    //비밀번호 수정

    @PatchMapping("/{id}/pass")
    public String updatePass(@PathVariable Long id,@RequestBody PassUpdateDto passUpdateDto){
        if(!id.equals(user.getUser().getId())) {
            return "회원정보 수정은 본인만 가능합니다.";
        }
        passService.pwUpdate(id,passUpdateDto);
        return "비밀번호 수정이 완료되었습니다.";
    }
    }







}
