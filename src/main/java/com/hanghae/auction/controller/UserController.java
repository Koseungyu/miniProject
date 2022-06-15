package com.hanghae.auction.controller;

import com.hanghae.auction.dto.ResponseDto;
import com.hanghae.auction.dto.SignupRequestDto;
import com.hanghae.auction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/user/signup")
    public ResponseDto signup(@RequestBody SignupRequestDto requestDto) {
        return userService.registerUser(requestDto);
    }
}



