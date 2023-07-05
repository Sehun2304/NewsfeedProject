package com.sparta.newsfeedproject.dto;


import com.sparta.newsfeedproject.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long id;
    private String email;
    private String name;
    private String nickname;
    private String introduce;

    public UserResponseDto(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.introduce = user.getIntroduce();

    }

}
