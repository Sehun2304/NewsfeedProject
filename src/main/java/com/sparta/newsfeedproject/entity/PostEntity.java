package com.sparta.newsfeedproject.entity;

import com.sparta.newsfeedproject.dto.PostDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Time;


@Entity
@Getter
@Setter
@Table(name = "post_table")
public class PostEntity extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String postWriter;

    @Column
    private String password;

    @Column
    private String title;

    @Column(length = 500)
    private String contents;

    @Column
    private int postHits;

    @Column
    private Long likeCount;

    public PostEntity(PostDto postDto) {
        this.password = postDto.getPassword();
        this.title = postDto.getTitle();
        this.contents = postDto.getContents();
        this.likeCount = 0L;
    }

    public PostEntity() {

    }

    public static PostEntity toSaveEntity(PostDto postDto){
        PostEntity postEntity = new PostEntity();
        postEntity.setPostWriter(postDto.getPostWriter());
        postEntity.setPassword(postDto.getPassword());
        postEntity.setTitle(postDto.getTitle());
        postEntity.setContents(postDto.getContents());
        postEntity.setPostHits(0);
        postEntity.setLikeCount(0L);
        return postEntity;
    }

    public static PostEntity toUpdateEntity(PostDto postDto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(postDto.getId());
        postEntity.setPostWriter(postDto.getPostWriter());
        postEntity.setPassword(postDto.getPassword());
        postEntity.setTitle(postDto.getTitle());
        postEntity.setContents(postDto.getContents());
        postEntity.setPostHits(postDto.getPostHits());
        postEntity.setLikeCount(0L);
        return postEntity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
