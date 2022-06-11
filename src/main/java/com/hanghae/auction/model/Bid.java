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
        initialValue = 1, allocationSize = 50)
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BID_ID_A")
    private Long id;

    private Long price;
}
