package com.hanghae.auction.model;

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
public class Product extends Timestamped{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long pid;

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

    @OneToMany
    @JoinColumn(name="uid")
    private List<Users> id = new ArrayList<>();


    public Product(ProductRequestDto requestDto) {
        this.image=requestDto.getImage();
        this.title=requestDto.getTitle();
        this.price=requestDto.getPrice();
        this.description=requestDto.getDescription();
        this.endtime=requestDto.getEndtime();
        this.status=true;
    }

}
