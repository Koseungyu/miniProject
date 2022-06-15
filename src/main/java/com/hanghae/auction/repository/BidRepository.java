package com.hanghae.auction.repository;

import com.hanghae.auction.model.Bid;
import com.hanghae.auction.model.Product;
import com.hanghae.auction.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {
   Bid findByUser(Users user);
   List<Bid> findAllByProduct(Product product);
}
