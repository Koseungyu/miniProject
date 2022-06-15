package com.hanghae.auction.controller;

import com.hanghae.auction.dto.ProductRequestDto;
import com.hanghae.auction.model.Product;
import com.hanghae.auction.repository.ProductRepository;
import com.hanghae.auction.security.UserDetailsImpl;
import com.hanghae.auction.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/product")
    public List<Product> getThumbnail() {
        return productService.getThumbnail();
    }

    @GetMapping("/api/product/{pid}")
    public Product getProduct(@PathVariable Long pid) {
        return productService.getProduct(pid);
    }

    @PostMapping("/api/product")
    public Product createProduct(@RequestBody ProductRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
            return productService.createProduct(requestDto, userDetails);
    }

    @DeleteMapping("/api/product/{pid}")
    public Boolean deleteProduct(@PathVariable Long pid) {
        return productService.deleteProduct(pid);
    }

    @PutMapping("/api/product/{pid}")
    public Product changeStatus(@PathVariable Long pid) {
        return productService.changeStatus(pid);
    }

}
