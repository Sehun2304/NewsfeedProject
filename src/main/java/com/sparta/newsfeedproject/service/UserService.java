package com.sparta.newsfeedproject.service;

import com.sparta.newsfeedproject.dto.ApiResponseDto;
import com.sparta.newsfeedproject.dto.RegisterRequest;
import com.sparta.newsfeedproject.dto.UpdateRequestDto;
import com.sparta.newsfeedproject.dto.UserResponseDto;
import com.sparta.newsfeedproject.entity.User;
import com.sparta.newsfeedproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


//    public User register(RegisterRequest registerRequest) {
//        User user = new User();
//        user.setUsername(registerRequest.getUsername());
//        user.setPassword(registerRequest.getPassword());
//        return userRepository.save(user);
//    }

    public User register(RegisterRequest request) {
        String username = request.getUsername();
        String password = passwordEncoder.encode(request.getPassword());
        String name = request.getName();
        String email = request.getEmail();
        String introduce = request.getIntroduce();

        //회원 중복 확인 -> 중복된 사용자가 존재하면 가입 x
        if(userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }
        // 닉네임, 이메일도 추가적으로 검증이 필요할 것 같음

        // 사용자 등록
        User user = new User(username, password, name, email, introduce);
        return userRepository.save(user);
    }


    public UserResponseDto getUser(Long id){
        User user = findUser(id);
        return new UserResponseDto(user);
    }


    public ResponseEntity<ApiResponseDto> updateUser(Long id, UpdateRequestDto updateRequestDto) {
        return null;
    }

    private User findUser(Long id){
        return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("잘못된 유저입니다"));
    }

}

