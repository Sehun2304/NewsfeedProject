package com.sparta.newsfeedproject.repository;

import com.sparta.newsfeedproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
