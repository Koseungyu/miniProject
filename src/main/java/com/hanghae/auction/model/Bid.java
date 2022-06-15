package com.hanghae.auction.model;


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
    private Long price;

    @Column(nullable = false)
    private Long count;

    public Bid(Users user, Product product, Long price) {
        this.user = user;
        this.product = product;
        this.price = price;
        this.count = 0L;
    }
}
