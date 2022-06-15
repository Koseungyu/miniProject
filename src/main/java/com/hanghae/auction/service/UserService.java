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

//        ValidateChecker.registerValidCheck(requestDto);
        ResponseDto responseDto = new ResponseDto();
        Boolean result = true;
        String err_msg = "사용가능한 ID 입니다.";
        String username = requestDto.getUsername();

        Optional<Users> foundname = userRepository.findByUsername(username);

        if (foundname.isPresent()) {
            err_msg = "중복된 ID가 존재합니다.";
            result = false;
            responseDto.setResult(false);
            return responseDto;
        }

        String password = passwordEncoder.encode(requestDto.getPassword());

        Users user = new Users(username, password);
        userRepository.save(user);

        return responseDto;
    }
}