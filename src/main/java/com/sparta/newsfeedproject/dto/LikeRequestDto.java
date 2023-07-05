package com.sparta.newsfeedproject.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeRequestDto {

    private Long userId;
    private Long boardId;

    public LikeRequestDto(Long userId, Long boardId) {
        this.userId = userId;
        this.boardId = boardId;
    }
}
