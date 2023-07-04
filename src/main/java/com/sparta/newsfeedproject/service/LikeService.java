package com.sparta.newsfeedproject.service;

import com.sparta.newsfeedproject.dto.LikeRequestDto;
import com.sparta.newsfeedproject.entity.Board;
import com.sparta.newsfeedproject.entity.Like;
import com.sparta.newsfeedproject.entity.User;
import com.sparta.newsfeedproject.repository.BoardRepository;
import com.sparta.newsfeedproject.repository.LikeRepository;
import com.sparta.newsfeedproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public String likeBoard(LikeRequestDto likeRequestDTO) {

        User user = userRepository.findById(likeRequestDTO.getUserId())
                .orElseThrow(() -> new NullPointerException("Could not found member id"));

        Board board = boardRepository.findById(likeRequestDTO.getBoardId())
                .orElseThrow(() -> new NullPointerException("Could not found board id"));

        // 이미 해당 게시글에 좋아요를 누른 아이디인지 체크
        if (likeRepository.findByUserAndBoard(user, board) != null){
            Like like = likeRepository.findByUserAndBoard(user,board);
            board.setLikeCount(board.getLikeCount()-1);
            likeRepository.delete(like);

            return "좋아요 취소";
        } else {
            Like like = new Like();
            like.setBoard(board);
            like.setUser(user);
            board.setLikeCount(board.getLikeCount()+1);

            likeRepository.save(like);
            return "좋아요";
        }

    }
}
