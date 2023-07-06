package com.sparta.newsfeedproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sparta.newsfeedproject.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {
    private Boolean success;
    private Long id;
    private String body;
    private String username;


    public CommentResponseDto(Comment comment) {
        super();
        this.id = comment.getId();
        this.username = comment.getUser().getUsername();
        this.body = comment.getBody();
    }

    public CommentResponseDto(Boolean success) {
        this.success = success;
    }
}
