package com.sparta.newsfeedproject.repository;

import com.sparta.newsfeedproject.entity.Board;
import com.sparta.newsfeedproject.entity.Like;
import com.sparta.newsfeedproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Like findByUserAndBoard(User member, Board board);

    List<Like> findByBoardId(Long boardId);
}
