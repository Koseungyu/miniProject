package com.hanghae.auction.repository;

import com.hanghae.auction.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
//    Bid findByUser(Users user);
}