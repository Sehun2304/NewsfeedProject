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
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String introduce;
    // 기본 생성자
    public User() {
    }

    // 매개변수가 있는 생성자
    public User(String username, String password,String name, String email, String introduce) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.introduce = introduce;
    }

    // Getter methods
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getIntroduce() {
        return introduce;
    }

    // Setter methods
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}

