package com.hanghae.auction.service;

import com.hanghae.auction.dto.BidPriceRequestDto;
import com.hanghae.auction.model.Bid;
import com.hanghae.auction.model.Product;
import com.hanghae.auction.model.Users;
import com.hanghae.auction.repository.BidRepository;
import com.hanghae.auction.repository.ProductRepository;
import com.hanghae.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Bid bid = bidRepository.findById(1L).orElse(null);      // USER AND PRODUCT를 통해 해당 경매 검색 예정

        if(bid == null){
            bid = new Bid(user, product, price);
        }else{
            bid.setPrice(price);
        }

        Bid savedBid = bidRepository.save(bid);
        return new BidPriceRequestDto(savedBid.getPrice());
    }

}
