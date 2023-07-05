package com.sparta.newsfeedproject.repository;

import com.sparta.newsfeedproject.entity.Like;
import com.sparta.newsfeedproject.entity.PostEntity;
import com.sparta.newsfeedproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByPostEntityId(Long postEntityId);
    Like findByUserAndPostEntity(User user, PostEntity post);
}
