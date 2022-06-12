package com.hanghae.auction.controller;

import com.hanghae.auction.dto.ResultResponseDto;
import com.hanghae.auction.dto.SignupRequestDto;
import com.hanghae.auction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 항해 전 기수가 했던 내용을 찾아봤다. 근데 회원 로그인 페이지 겟 맵핑, 회원가입 페이지 갯맵핑 api가 따로 없더라. 이건 프론트 쪽에서 별도로 보이게 해줄수 있는건지?
    // 회원가입 오청 처리, 아이디 중복체크
    // 어제 wil 쓰시면서 확인해보셨겠지만 cors를 넣어줘야한다. 만들어놓고 아닌 것 같아서 지워버렸다. 혹시 이 점에 대해 아는지 궁금하다. 설명해주실 분이 있으신가?
    // jwt 성민님이 봤을때 jwt를 넣어서 해야하는건지 궁금하다.


    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() { return "login"; }


    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }


    // 회원가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto){
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }

    //아이디 중복체크
    @GetMapping("/user?username")
    public ResultResponseDto duplicateUsername(@PathVariable String username) {
        return userService.duplicateUsername(username);
    }

    //회원가입
//    @PostMapping("/user/signup")
//    public ResponseEntity<String> registerUser(@Valid @RequestBody SignupRequestDto requestDto) {
//        System.out.println(requestDto);
//        userService.registerUser(requestDto);
//        return ResponseEntity.ok()
//                .body("회원가입 완료");
//    }
}



