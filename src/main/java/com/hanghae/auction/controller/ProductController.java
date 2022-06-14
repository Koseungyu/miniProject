package com.hanghae.auction.controller;

import com.hanghae.auction.dto.ProductRequestDto;
import com.hanghae.auction.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final com.hanghae.auction.repository.ProductRepository ProductRepository;
    private final com.hanghae.auction.service.ProductService ProductService;

    @GetMapping("/api/product")
    public List<Product> getThumbnail() {
        return ProductRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/product/{pid}")
    public Product getProduct(@PathVariable Long pid) {
        return ProductService.getProduct(pid);
    }

    @PostMapping("/api/product")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) {
        return ProductService.createProduct(requestDto);
    }

    @DeleteMapping("/api/product/{pid}")
    public Boolean deleteProduct(@PathVariable Long pid) {
        return ProductService.deleteProduct(pid);
    }

}
