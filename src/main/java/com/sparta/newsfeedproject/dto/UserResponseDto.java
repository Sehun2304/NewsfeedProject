package com.sparta.newsfeedproject.dto;


import com.sparta.newsfeedproject.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long id;
    private String email;
    private String name;
    private String username;
    private String introduce;

    public UserResponseDto(User users){
        this.id = users.getId();
        this.email = users.getEmail();
        this.name = users.getName();
        this.username = users.getUsername();
        this.introduce = users.getIntroduce();

    }

}
