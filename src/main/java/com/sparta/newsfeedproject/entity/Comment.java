package com.sparta.newsfeedproject.entity;

import com.sparta.newsfeedproject.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comment")
public class Comment extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String password;

    public Comment(CommentRequestDto commentRequestDto) {
        this.id = commentRequestDto.getPostId();
        this.body = commentRequestDto.getBody();
        this.password = commentRequestDto.getPassword();
    }

    public Comment(String body) {
        this.body = body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    // 비밀번호 체크하는 함수
    public void checkPassword(String inputPassword) {
        if (!password.equals(inputPassword)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

}

