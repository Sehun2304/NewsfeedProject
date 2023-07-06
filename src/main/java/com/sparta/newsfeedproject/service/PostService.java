package com.sparta.newsfeedproject.service;

import com.sparta.newsfeedproject.dto.PostDto;
import com.sparta.newsfeedproject.entity.PostEntity;
import com.sparta.newsfeedproject.repository.PostRepository;
import com.sparta.newsfeedproject.security.UserDetailsImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 게시글 작성
    public void save(PostDto postDto, UserDetailsImpl userDetails) {
//        PostEntity postEntity = PostEntity.toSaveEntity(postDto);
//        postEntity.setPostWriter(userDetails.getUsername());

        PostEntity postEntity = new PostEntity(postDto);
        postEntity.setPostWriter(userDetails.getUsername());
        postRepository.save(postEntity);
    }

    //전체 게시글 조회
    public List<PostDto> findAll() {
        List<PostEntity>postEntityList = postRepository.findAll();
        List<PostDto> postDtoList = new ArrayList<>();
        for(PostEntity postEntity: postEntityList){
            postDtoList.add(PostDto.toPostDTO(postEntity));
        }
        return postDtoList;
    }

    @Transactional
    public void updateHits(Long id) {
        postRepository.updateHits(id);
    }

    //선택 게시글 조회
    public PostDto findById(Long id) {
        Optional<PostEntity>optionalPostEntity = postRepository.findById(id);
        if(optionalPostEntity.isPresent()){
            PostEntity postEntity = optionalPostEntity.get();
            PostDto postDto = PostDto.toPostDTO(postEntity);
            return postDto;
        } else {
            return null;
        }
    }

    // 게시글 수정
    @Transactional
    public PostDto update(PostDto postDto, Long id, UserDetailsImpl userDetails) {
//        PostEntity postEntity = PostEntity.toUpdateEntity(postDto);
//        postRepository.save(postEntity);
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("해당 게시글이 존재하지 않습니다."));

        if (postEntity.getPostWriter().equals(userDetails.getUsername())) {
            postEntity.setTitle(postDto.getTitle());
            postEntity.setContents(postDto.getContents());
        } else {
            throw new IllegalArgumentException("아이디가 일치하지 않습니다.");
        }

        return findById(postDto.getId());
    }

    // 게시글 삭제
    public void delete(Long id, UserDetailsImpl userDetails) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("해당 게시글이 존재하지 않습니다."));
        if(postEntity.getPostWriter().equals(userDetails.getUsername())) {
            postRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("아이디가 일치하지 않습니다.");
        }
    }
}
