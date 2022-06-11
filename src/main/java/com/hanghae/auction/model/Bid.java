package com.hanghae.auction.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        uniqueConstraints={
                @UniqueConstraint(
                        name="BID_ID_A",
                        columnNames = {"BID_ID_B", "name"}
                )
        }
)
@SequenceGenerator(
        name = "BID_ID_A",
        sequenceName = "BID_ID_B",
        initialValue = 1, allocationSize = 1000)
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BID_ID_A")
    private Long id;

//    @OneToOne(name="USER_ID")
//    private Users user;

//    @ManyToOne(name="PRODUCT_ID")
//    private Product product;

    @Column(nullable = false)
    private Long price = 0L;

    @Column(nullable = false)
    private Long count = 0L;

    public Bid(Long pid, Long uid) {

    }

    public void bidProduct(Long price){
        if(this.price > price)
            throw new IllegalArgumentException("기존 입찰가보다 적은 금액입니다.");
        else
            this.price = price;
    }
}
