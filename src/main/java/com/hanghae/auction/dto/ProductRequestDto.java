package com.hanghae.auction.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductRequestDto {
    private String image;

    private String title;

    private Long price;

    private String description;

    private String endtime;


}
