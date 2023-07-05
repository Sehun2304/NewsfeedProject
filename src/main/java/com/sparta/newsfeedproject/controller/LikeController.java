package com.sparta.newsfeedproject.controller;

import com.sparta.newsfeedproject.dto.LikeRequestDto;
import com.sparta.newsfeedproject.service.LikeService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/like")
    public String like(@RequestBody LikeRequestDto likeRequestDto) {

        return likeService.likeBoard(likeRequestDto);
    }
}
