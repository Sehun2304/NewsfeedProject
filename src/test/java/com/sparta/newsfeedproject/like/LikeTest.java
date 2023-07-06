package com.sparta.newsfeedproject.like;

import com.sparta.newsfeedproject.entity.Board;
import com.sparta.newsfeedproject.entity.User;
import com.sparta.newsfeedproject.repository.BoardRepository;
import com.sparta.newsfeedproject.repository.LikeRepository;
import com.sparta.newsfeedproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class LikeTest {
    @Autowired
    LikeRepository likeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BoardRepository boardRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void init() {
        User user = new User();
        user.setId(1L);
        userRepository.save(user);

        User user2 = new User();
        user2.setId(2L);
        userRepository.save(user2);

        User user3 = new User();
        user3.setId(3L);
        userRepository.save(user3);

        Board board = new Board();
        board.setId(1L);
        board.setLikeCount(0L);
        boardRepository.save(board);

        Board board2 = new Board();
        board2.setId(2L);
        board2.setLikeCount(0L);
        boardRepository.save(board2);

        Board board3 = new Board();
        board3.setId(3L);
        board3.setLikeCount(0L);
        boardRepository.save(board3);
    }
}
