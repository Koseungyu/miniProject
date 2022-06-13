package com.hanghae.auction.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
//    private String passwordcheck;
//
//    public SignupRequestDto(String username, String password, String passwordcheck) {
//        this.username = username;
//        this.password = password;
//        this.passwordcheck = passwordcheck;
//    }
//
//    public SignupRequestDto(boolean existsByUsername) {
//    }
}
