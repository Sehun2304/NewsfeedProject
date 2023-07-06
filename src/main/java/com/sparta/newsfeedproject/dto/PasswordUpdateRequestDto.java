package com.sparta.newsfeedproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordUpdateRequestDto {
    private String password;
    private String newPassword;
}
