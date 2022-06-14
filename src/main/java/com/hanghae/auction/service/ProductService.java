package com.hanghae.auction.service;

import com.hanghae.auction.dto.ProductRequestDto;
import com.hanghae.auction.model.Product;
import com.hanghae.auction.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    @Transactional
    public Product getProduct(@PathVariable Long pid) {
        Product product =  productRepository.findById(pid).orElseThrow(
                ()->new IllegalArgumentException("productId가 존재하지 않습니다."));
        return product;
    }
    @Transactional
    public Boolean deleteProduct(@PathVariable Long pid) {

        productRepository.deleteById(pid);
            return true;
        }

    @Transactional
    public Product createProduct(@RequestBody ProductRequestDto requestDto) {
        Product product = new Product(requestDto);
        String title= requestDto.getTitle();
        Long price= requestDto.getPrice();
        String description=requestDto.getDescription();
        if (price%100 !=0){
            throw new IllegalArgumentException("100원 단위로 입력해주세요.");
        }
        else if(title.length()>=15){
            throw new IllegalArgumentException("15자 이내로 입력해주세요");
        }
        else if(description.length()>=20){
            throw new IllegalArgumentException("20자 이내로 입력해주세요");
        }
        else {
            return productRepository.save(product);
        }
    }
}
