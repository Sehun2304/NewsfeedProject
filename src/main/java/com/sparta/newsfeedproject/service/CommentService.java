//package com.sparta.newsfeedproject.service;
//
//import com.sparta.newsfeedproject.dto.CommentRequestDto;
//import com.sparta.newsfeedproject.dto.CommentResponseDto;
//import com.sparta.newsfeedproject.entity.Comment;
//import com.sparta.newsfeedproject.repository.CommentRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class CommentService {
//
//    private final CommentRepository commentRepository;
//
//    public CommentService(CommentRepository commentRepository) {
//        this.commentRepository = commentRepository;
//    }
//
//    @Deprecated
//    public List<CommentResponseDto> getCommentList() {
//        List<Comment> commentList = commentRepository.findAllByOrderByCreateAtDesc();
//        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
//        for (Comment comment : commentList) {
//            commentResponseDtoList.add(new CommentResponseDto(comment));
//        }
//        return commentResponseDtoList;
//    }
//
//    public CommentResponseDto createComment(CommentRequestDto commentRequestDto) {
//
//        Comment comment = new Comment(commentRequestDto);
//
//        Comment saveComment = commentRepository.save(comment);
//        return new CommentResponseDto(saveComment);
//    }
//
//    @Transactional
//    public CommentResponseDto updateComment(Long id, CommentRequestDto commentRequestDto) {
//        Comment comment = findComment(id);
//
//        comment.checkPassword(commentRequestDto.getPassword());
//
//        comment.setBody(commentRequestDto.getBody());
//
//        return new CommentResponseDto(comment);
//    }
//
//    public void deleteComment(Long id, String password) {
//        Comment comment = findComment(id);
//
//        comment.checkPassword(password);
//
//
//        commentRepository.delete(comment);
//    }
//    private Comment findComment(Long id) {
//        return commentRepository.findById(id).orElseThrow(() ->
//                new IllegalArgumentException("댓글이 존재하지 않습니다")
//        );
//    }
//
//}
