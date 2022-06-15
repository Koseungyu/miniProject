package com.hanghae.auction.service;

import com.hanghae.auction.dto.ProductRequestDto;
import com.hanghae.auction.dto.ResponseDto;
import com.hanghae.auction.model.Product;
import com.hanghae.auction.model.Users;
import com.hanghae.auction.repository.ProductRepository;
import com.hanghae.auction.repository.UserRepository;
import com.hanghae.auction.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Product getProduct(@PathVariable Long pid) {
        return productRepository.findById(pid).orElseThrow(
                ()->new IllegalArgumentException("productId가 존재하지 않습니다."));
    }

    @Transactional
    public ResponseDto deleteProduct(@PathVariable Long pid, UserDetailsImpl userDetails) {
        Users user = userRepository.findById(userDetails.getUser().getId()).orElseThrow(() -> new NullPointerException("존재하지 않은 사용자 ID입니다."));
        Product product = productRepository.findById(pid).orElseThrow(() -> new NullPointerException("존재하지 않은 제품입니다."));

        productRepository.deleteById(pid);
        return new ResponseDto("삭제 성공하셨습니다.");
    }

    @Transactional
    public Product createProduct(@RequestBody ProductRequestDto requestDto, UserDetailsImpl userDetails) {
        Users user = userRepository.findById(userDetails.getUser().getId()).orElseThrow(() -> new NullPointerException("존재하지 않은 사용자 ID입니다."));
        Product product = new Product(requestDto, user);

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

    public Product changeStatus(Long pid) {
        Product product =  productRepository.findById(pid).orElseThrow(
                ()->new IllegalArgumentException("productId가 존재하지 않습니다."));

        product.setStatus(false);
        return productRepository.save(product);
    }

    public List<Product> getThumbnail() {
        return productRepository.findAllByOrderByCreatedAtDesc();
    }
}
