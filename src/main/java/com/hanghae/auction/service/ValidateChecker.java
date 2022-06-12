package com.hanghae.auction.service;

import com.hanghae.auction.dto.SignupRequestDto;
import com.hanghae.auction.model.Users;
import com.hanghae.auction.security.UserDetailsImpl;

import java.util.regex.Pattern;

public class ValidateChecker {
    public static Users userDetailsIsNull(UserDetailsImpl userDetails){
        if(userDetails != null){
            return userDetails.getUser();
        }else{
            throw new NullPointerException("유효하지 않은 사용자입니다.");
        }
    }

    public static void registerValidCheck(SignupRequestDto signupRequestDto) {
        // 회원 ID 중복 확인
        // 1. 아이디가 6~20자의 대소문자/숫자 조합인지 (어떻게 해야할까?)
        // 2. 비밀번호와 비밀번호 확인이 일치하는지
        String username = signupRequestDto.getUsername();
        String password = signupRequestDto.getPassword();
        String passwordcheck = signupRequestDto.getPasswordcheck();

        if (!Pattern.compile(username).matcher(username).find()) {
            throw new IllegalArgumentException("아이디는 숫자와 영문자 조합으로 6~15자리를 사용해야합니다.");
//            /^[a-z]+[a-z0-9]{5,14}$/g;
        }else if (!password.equals(passwordcheck)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//            /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/
        }
    }
}