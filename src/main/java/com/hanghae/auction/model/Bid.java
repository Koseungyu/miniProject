package com.hanghae.auction.model;


import com.hanghae.auction.validator.BidValidator;
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

    @OneToOne
    @JoinColumn(name="USER_ID")
    private Users user;

    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    private Product product;

    @Column(nullable = false)
    private Long price = 0L;

    @Column(nullable = false)
    private Long count = 0L;

    public Bid(Users user, Product product, Long price) {
        if(price <= 0)
            throw new IllegalArgumentException("최저 입찰가가 잘못되었습니다.");

        this.user = user;
        this.product = product;
        this.price = price;
    }

    public void setPrice(Long price) {
        this.price = BidValidator.validationPrice(this.price, price);
    }
}
