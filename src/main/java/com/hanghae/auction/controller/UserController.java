package com.hanghae.auction.controller;

import com.hanghae.auction.dto.ResponseDto;
import com.hanghae.auction.dto.SignupRequestDto;
import com.hanghae.auction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/user/signup")
    public ResponseDto signup(@RequestBody SignupRequestDto requestDto) { return userService.registerUser(requestDto);
    }


//    // 유저네임 중복 검사 - 모달
//    @PostMapping("/user/usernameCheck")
//    public ResponseDto usernameCheck(@RequestBody SignupRequestDto requestDto) {
//        return userService.usernameCheck(requestDto);
//    }


//    // 회원 로그인 페이지
//    @GetMapping("/user/login")
//    public String login() { return "login"; }


//    // 회원가입 페이지
//    @GetMapping("/user/signup")
//    public String signup() {
//        return "signup";
//    }
//
//
//    // 회원가입 요청 처리
//    @PostMapping("/user/signup")
//    public String registerUser(SignupRequestDto requestDto){
//        userService.registerUser(requestDto);
//        return "redirect:/user/login";
//    }
//
//    //아이디 중복체크
//    @GetMapping("/user?username")
//    public ResultResponseDto duplicateUsername(@PathVariable String username) {
//        return userService.duplicateUsername(username);
//    }

    //회원가입
//    @PostMapping("/user/signup")
//    public ResponseEntity<String> registerUser(@Valid @RequestBody SignupRequestDto requestDto) {
//        System.out.println(requestDto);
//        userService.registerUser(requestDto);
//        return ResponseEntity.ok()
//                .body("회원가입 완료");
//    }
}



