package com.hanghae.auction.service;

import com.hanghae.auction.model.Bid;
import com.hanghae.auction.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService {
    // private final UserRepository userRepository;
    // private final ProductRepository productRepository;

    private final BidRepository bidRepository;

    @Autowired
    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public Long doBid(Long pid, Long uid, Long price) {
        // Product product = productRepository.findById(pid).orElseThrow(() -> new NullPointerException("존재하지 않는 제품입니다."));
        // Users user = userRepository.findById(uid).orElseThrow(() -> new NullPointerException("존재하지 않는 제품입니다."));
        // Users user = new Users();
        Bid bid = bidRepository.findById(1L).orElse(null);

        if(bid == null){
            bid = new Bid(pid, uid);
        }

        bid.bidProduct(price);
        bidRepository.save(bid);
        return bid.getPrice();
    }

}
