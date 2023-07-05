package com.sparta.newsfeedproject.controller;

import com.sparta.newsfeedproject.dto.CommentRequestDto;
import com.sparta.newsfeedproject.dto.CommentResponseDto;
import com.sparta.newsfeedproject.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    //생성
    @PostMapping("/comments")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto commentRequestDto){
        return commentService.createComment(commentRequestDto);
    }

    //수정
    @PutMapping("/comments/{id}")
    public CommentResponseDto updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto){
        return commentService.updateComment(id, commentRequestDto);
    }

    //삭제
    @DeleteMapping("/comments/{id}")
    public CommentResponseDto deleteComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto){
        commentService.deleteComment(id, commentRequestDto.getPassword());
        return new CommentResponseDto(true);
    }

}
