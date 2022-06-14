package com.hanghae.auction.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@NoArgsConstructor
public class ProductRequestDto {
    private String image;

    private String title;

    private Long price;

    private String description;

    private String endtime;

    public ProductRequestDto(String image, String title, Long price, String description, String endtime) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.description = description;
        this.endtime = endtime;
    }
}
