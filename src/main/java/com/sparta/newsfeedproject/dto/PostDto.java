package com.sparta.newsfeedproject.dto;

import com.sparta.newsfeedproject.entity.PostEntity;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;
    private String postWriter;
    private String password;
    private String title;
    private String contents;
    private int postHits;
    private LocalDateTime postCreatedTime;
    private LocalDateTime postUpdatedTime;

    public static PostDto toPostDTO(PostEntity postEntity){
        PostDto postDto = new PostDto();
        postDto.setId(postEntity.getId());
        postDto.setPostWriter(postEntity.getPostWriter());
        postDto.setPassword(postEntity.getPassword());
        postDto.setTitle(postEntity.getTitle());
        postDto.setContents(postEntity.getContents());
        postDto.setPostHits(postEntity.getPostHits());
        postDto.setPostCreatedTime(postEntity.getCreatedTime());
        postDto.setPostUpdatedTime(postEntity.getUpdatedTime());
        return postDto;
    }
}
