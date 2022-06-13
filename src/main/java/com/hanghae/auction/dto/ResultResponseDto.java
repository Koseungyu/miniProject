package com.hanghae.auction.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResultResponseDto {
    private boolean result;
    private String message;

//    public ResultResponseDto(boolean result, String message) {
//        this.result = result;
//        this.message = message;
//    }
//
//    public ResultResponseDto(boolean result) {
//        this.result = result;
//    }
}