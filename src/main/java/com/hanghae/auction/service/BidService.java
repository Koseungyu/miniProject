package com.hanghae.auction.service;

import com.hanghae.auction.dto.BidCountResponseDto;
import com.hanghae.auction.dto.BidPriceRequestDto;
import com.hanghae.auction.model.Bid;
import com.hanghae.auction.model.Product;
import com.hanghae.auction.model.Users;
import com.hanghae.auction.repository.BidRepository;
import com.hanghae.auction.repository.ProductRepository;
import com.hanghae.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    private final BidRepository bidRepository;

    @Autowired
    public BidService(UserRepository userRepository, ProductRepository productRepository, BidRepository bidRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.bidRepository = bidRepository;
    }

    public BidPriceRequestDto doBid(Long pid, Long uid, Long price) {
        Product product = productRepository.findById(pid).orElseThrow(() -> new NullPointerException("존재하지 않는 제품입니다."));
        Users user = userRepository.findById(uid).orElseThrow(() -> new NullPointerException("존재하지 않는 제품입니다."));

        Bid bid = bidRepository.findByUser(user);

        if(product.getPrice() >= price){
            throw new IllegalArgumentException("기존 가격보다 적은 금액입니다.");
        } else if(price % 100 != 0){
            throw new IllegalArgumentException("기존 가격보다 적은 금액입니다.");
        }

        if(bid == null){
            bid = new Bid(user, product, price);
        }else{
            bid.setPrice(price);
        }

        product.setPrice(price);
        Product savedProduct = productRepository.save(product);
        Bid savedBid = bidRepository.save(bid);
        return new BidPriceRequestDto(savedBid.getPrice());
    }

    public BidCountResponseDto getBidCount(Long pid) {
        Product product = productRepository.findById(pid).orElseThrow(() -> new NullPointerException("존재하지 않는 제품입니다."));
        List<Bid> bid = bidRepository.findAllByProduct(product);
        return new BidCountResponseDto(bid.size());
    }
}
