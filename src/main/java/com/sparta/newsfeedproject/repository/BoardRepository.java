package com.sparta.newsfeedproject.repository;

import com.sparta.newsfeedproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
