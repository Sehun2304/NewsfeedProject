package com.sparta.newsfeedproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String introduce;

    // 기본 생성자
    public User() {
    }

    public User(String username, String password, String name, String email, String introduce) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.introduce = introduce;
    }
}

