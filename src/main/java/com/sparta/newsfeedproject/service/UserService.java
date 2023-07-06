package com.sparta.newsfeedproject.service;

import com.sparta.newsfeedproject.dto.PasswordUpdateRequestDto;
import com.sparta.newsfeedproject.dto.ProfileUpdateRequestDto;
import com.sparta.newsfeedproject.dto.RegisterRequest;
import com.sparta.newsfeedproject.dto.UserResponseDto;
import com.sparta.newsfeedproject.entity.User;
import com.sparta.newsfeedproject.repository.UserRepository;
import com.sparta.newsfeedproject.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User register(RegisterRequest request) {
        String username = request.getUsername();
        String password = passwordEncoder.encode(request.getPassword());
        String name = request.getName();
        String email = request.getEmail();
        String introduce = request.getIntroduce();

        //회원 중복 확인 -> 중복된 사용자가 존재하면 가입 x
        if (userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }
        // 닉네임, 이메일도 추가적으로 검증이 필요할 것 같음

        // 사용자 등록
        User user = new User(username, password, name, email, introduce);
        return userRepository.save(user);
    }

    // 유저 프로필 조회
    public UserResponseDto viewUser(UserDetailsImpl userDetails) {
        User user = findUser(userDetails.getUser().getId());
        return new UserResponseDto(user);
    }


    public void updateUser(UserDetailsImpl userDetails, ProfileUpdateRequestDto profileUpdateRequestDto) {
        User user = findUser(userDetails.getUser().getId());

        if (user == null) {
            throw new IllegalArgumentException("해당 ID의 사용자를 찾을 수 없습니다.");
        }

        // 입력한 비밀번호 확인
        if (!passwordEncoder.matches(profileUpdateRequestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // 비밀번호가 맞으면 소개 수정
        String newIntroduce = profileUpdateRequestDto.getIntroduce();
        user.setIntroduce(newIntroduce);

        userRepository.save(user);
    }

    // 비밀번호 수정
    public void updatePassword(UserDetailsImpl userDetails, PasswordUpdateRequestDto passwordUpdateRequestDto) {
        // 기존 비밀번호를 입력했을 때 비밀 번호가 일치하지 않는다면 예외 발생
        if (!passwordEncoder.matches(passwordUpdateRequestDto.getPassword(), userDetails.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        } else {
            // 기존 비밀번호가 일치하면 새로운 비밀번호로 기존 비밀번호 수정
            User user = findUser(userDetails.getUser().getId());
            user.setPassword(passwordEncoder.encode(passwordUpdateRequestDto.getNewPassword()));
            userRepository.save(user);
        }
    }

    private User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 유저입니다"));
    }

}

