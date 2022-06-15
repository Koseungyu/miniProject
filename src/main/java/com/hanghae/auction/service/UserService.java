package com.hanghae.auction.service;

import com.hanghae.auction.dto.ResponseDto;
import com.hanghae.auction.dto.SignupRequestDto;
import com.hanghae.auction.model.Users;
import com.hanghae.auction.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public ResponseDto registerUser(SignupRequestDto requestDto) {
        ResponseDto responseDto;
        String username = requestDto.getUsername();
        Optional<Users> foundname = userRepository.findByUsername(username);

        if (foundname.isPresent()) {
            responseDto = new ResponseDto(false, "중복된 ID가 존재합니다.");
            return responseDto;
        }

        String password = passwordEncoder.encode(requestDto.getPassword());

        Users user = new Users(username, password);
        userRepository.save(user);

        return new ResponseDto("회원가입 성공");
    }
}