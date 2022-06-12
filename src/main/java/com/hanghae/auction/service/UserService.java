package com.hanghae.auction.service;

import com.hanghae.auction.dto.ResultResponseDto;
import com.hanghae.auction.dto.SignupRequestDto;
import com.hanghae.auction.model.Users;
import com.hanghae.auction.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    // username, password 저장.
    public void registerUser(SignupRequestDto requestDto) {

        ValidateChecker.registerValidCheck(requestDto);

        String username = requestDto.getUsername();
        Optional<Users> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }

        String password = passwordEncoder.encode(requestDto.getPassword());

        Users user = new Users(username, password);
        userRepository.save(user);
    }

    //username 중복확인
    public ResultResponseDto duplicateUsername(String username) {
        return new ResultResponseDto(userRepository.existsByUsername(username));
    }
}