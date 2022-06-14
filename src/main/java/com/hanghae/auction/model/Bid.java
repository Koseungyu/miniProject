package com.hanghae.auction.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @OneToOne(name="USER_ID")
//    private Users user;

//    @ManyToOne(name="PRODUCT_ID")
//    private Product product;

    @Column(nullable = false)
    private Long price = 0L;

    @Column(nullable = false)
    private Long count = 0L;


    public void bidProduct(Long price){
        if(this.price > price)
            throw new IllegalArgumentException("기존 입찰가보다 적은 금액입니다.");
        else
            this.price = price;
    }
}
