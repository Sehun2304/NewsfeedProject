package com.sparta.newsfeedproject.repository;

import com.sparta.newsfeedproject.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository <PostEntity, Long> {
    //update post_table set post_hits=post_hits+1 where id=?
    @Modifying
    @Query(value = "update PostEntity p set p.postHits=p.postHits+1 where p.id=:id")
    void updateHits(@Param("id")Long id);
}
