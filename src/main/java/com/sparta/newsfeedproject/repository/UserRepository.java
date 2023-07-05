package com.sparta.newsfeedproject.repository;

import org.springframework.stereotype.Repository;

import com.sparta.newsfeedproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

