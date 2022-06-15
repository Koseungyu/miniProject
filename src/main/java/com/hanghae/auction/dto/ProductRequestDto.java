package com.hanghae.auction.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    private String image;

    private String title;

    private Long price;

    private String description;

    private String endtime;
}
