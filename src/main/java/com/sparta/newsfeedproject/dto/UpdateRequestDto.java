package com.sparta.newsfeedproject.dto;


import lombok.Getter;

@Getter

public class UpdateRequestDto {
    private String username;
    private String password;
    private String checkPassword;
    private String newPassword;
    private String email;
    private String introduce;
    private String newIntroduce;
}


