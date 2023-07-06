package com.sparta.newsfeedproject.service;


import com.sparta.newsfeedproject.dto.PassUpdateDto;
import com.sparta.newsfeedproject.entity.User;
import com.sparta.newsfeedproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class PassService {

//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    @Transactional
//    public void passUpdate(Long id, PassUpdateDto passUpdateDto){
//        User user = userRepository.findById(id).orElseThrow(
//                NoSuchUserException::new
//        );
//        String password = passwordEncoder.encode(pwUpdateDto.getPassword());
//        user.passUpdate(password);
//    }

}
