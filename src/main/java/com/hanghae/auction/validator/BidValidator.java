package com.hanghae.auction.validator;

public class BidValidator {
    public static Long validationPrice(Long orginPrice, Long price){

        if(orginPrice > price)
            throw new IllegalArgumentException("기존 입찰가보다 적은 금액입니다.");
        else
        {
            orginPrice = price;
            return orginPrice;
        }

    }
}
