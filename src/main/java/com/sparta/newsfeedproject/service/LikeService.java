package com.sparta.newsfeedproject.service;

import com.sparta.newsfeedproject.dto.LikeRequestDto;
import com.sparta.newsfeedproject.entity.Like;
import com.sparta.newsfeedproject.entity.PostEntity;
import com.sparta.newsfeedproject.entity.User;
import com.sparta.newsfeedproject.repository.LikeRepository;
import com.sparta.newsfeedproject.repository.PostRepository;
import com.sparta.newsfeedproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public void likeBoard(LikeRequestDto likeRequestDTO) {

        User user = userRepository.findById(likeRequestDTO.getUserId())
                .orElseThrow(() -> new NullPointerException("Could not found user id"));
        /**
         * spring security 구현이 완료되면 밑에 주석 처리된 코드로 변경하면 인증된 토큰으로 user를 판단할 수 있을 것 같음
         * 아직은 구현이 안되어 있으므로 위에 있는 코드 사용
         */
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = userRepository.findByUsername(authentication.getName());

        PostEntity post = postRepository.findById(likeRequestDTO.getPostId())
                .orElseThrow(() -> new NullPointerException("Could not found board id"));

        // 이미 해당 게시글에 좋아요를 누른 아이디인지 체크
        if (likeRepository.findByUserAndPostEntity(user, post) != null){
            Like like = likeRepository.findByUserAndPostEntity(user,post);
            likeRepository.delete(like);

            Long likeCount = (long)likeRepository.findByPostEntityId(post.getId()).size();
            post.setLikeCount(likeCount);
        } else {
            Like like = new Like();
            like.setPostEntity(post);
            like.setUser(user);
            likeRepository.save(like);

            Long likeCount = (long)likeRepository.findByPostEntityId(post.getId()).size();
            post.setLikeCount(likeCount);
        }

    }
}
