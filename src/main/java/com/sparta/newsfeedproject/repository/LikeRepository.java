package com.sparta.newsfeedproject.repository;

import com.sparta.newsfeedproject.entity.Board;
import com.sparta.newsfeedproject.entity.Like;
import com.sparta.newsfeedproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Like findByUserAndBoard(User member, Board board);
}
