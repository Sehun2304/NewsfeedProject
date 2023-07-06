package com.sparta.newsfeedproject.service;

import com.sparta.newsfeedproject.dto.PostDto;
import com.sparta.newsfeedproject.entity.PostEntity;
import com.sparta.newsfeedproject.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 게시글 작성
    public void save(PostDto postDto) {
        PostEntity postEntity = PostEntity.toSaveEntity(postDto);
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


    public PostDto update(PostDto postDto) {
        PostEntity postEntity = PostEntity.toUpdateEntity(postDto);
        postRepository.save(postEntity);
        return findById(postDto.getId());
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
