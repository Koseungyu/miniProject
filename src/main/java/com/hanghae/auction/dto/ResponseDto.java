package com.hanghae.auction.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ResponseDto {
    private boolean result;
    private String err_msg;

    public ResponseDto(Boolean result, String err_msg) {
        this.result = result;
        this.err_msg = err_msg;
    }

    public ResponseDto(Boolean result) {
        this.result = result;
    }
}

