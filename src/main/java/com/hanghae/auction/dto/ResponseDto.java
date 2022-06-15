package com.hanghae.auction.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ResponseDto {
    private String username;
    private boolean result;
    private String err_msg;

    public ResponseDto(String err_msg) {
        this.result = result;
        this.err_msg = err_msg;
    }

    public ResponseDto(boolean result, String err_msg) {
        this.result = result;
        this.err_msg = err_msg;
    }
}

