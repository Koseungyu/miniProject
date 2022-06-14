package com.hanghae.auction.repository;

import com.hanghae.auction.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {


    Optional<Product>findById(Long pid);



    List<Product> findAllByOrderByCreatedAtDesc();
}
