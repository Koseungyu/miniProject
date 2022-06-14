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
@SequenceGenerator(
        name = "BID_A",
        sequenceName = "BID_B",
        initialValue = 1, allocationSize = 50)
public class Bid {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "BID_A")
    @Column(name = "BID_ID")
    private Long id;

    @ManyToOne
    @JoinColumn
    private Users user;

    @ManyToOne
    @JoinColumn
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
