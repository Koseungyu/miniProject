package com.hanghae.auction.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hanghae.auction.dto.ProductRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name = "PRODUCT_A",
        sequenceName = "PRODUCT_B",
        initialValue = 1, allocationSize = 50)
public class Product extends Timestamped{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "PRODUCT_A")
    @Column(name = "PRODUCT_ID")
    private Long pid;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="USER_ID")
    private Users user;

    @Column
    private String image;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private String endtime;

    public Product(ProductRequestDto requestDto, Users user) {
        this.image=requestDto.getImage();
        this.title=requestDto.getTitle();
        this.price=requestDto.getPrice();
        this.description=requestDto.getDescription();
        this.endtime=requestDto.getEndtime();
        this.status = true;

        this.user = user;
    }

}
