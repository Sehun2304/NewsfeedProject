package com.sparta.newsfeedproject.service;

import com.sparta.newsfeedproject.dto.ApiResponseDto;
import com.sparta.newsfeedproject.dto.RegisterRequest;
import com.sparta.newsfeedproject.dto.UpdateRequestDto;
import com.sparta.newsfeedproject.dto.UserResponseDto;
import com.sparta.newsfeedproject.entity.User;
import com.sparta.newsfeedproject.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User register(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        return userRepository.save(user);
    }



    public UserResponseDto viewUser(Long id){
        User user = findUser(id);
        return new UserResponseDto(user);
    }



    public static ResponseEntity<ApiResponseDto> updateUser(Long id, UpdateRequestDto updateRequestDto) {
    Optional<User> optionalUser = userRepository.findById(id);

    if (!optionalUser.isPresent()) {
        throw new IllegalArgumentException("해당 ID의 사용자를 찾을 수 없습니다.");
    }

    User updateUser = optionalUser.get();

    if (!updateRequestDto.getPassword().equals(updateRequestDto.getCheckPassword())) {
        throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
    }

    String newIntroduce = updateRequestDto.getNewIntroduce();
    updateUser.setIntroduce(newIntroduce);

    userRepository.save(updateUser);

    return ResponseEntity.ok(new ApiResponseDto());
}


    private User findUser(Long id){
        return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("잘못된 유저입니다"));
    }

}

