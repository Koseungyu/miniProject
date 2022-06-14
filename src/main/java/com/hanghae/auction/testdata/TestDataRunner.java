package com.hanghae.auction.testdata;

import com.hanghae.auction.dto.ProductRequestDto;
import com.hanghae.auction.model.Bid;
import com.hanghae.auction.model.Product;
import com.hanghae.auction.model.Users;
import com.hanghae.auction.repository.BidRepository;
import com.hanghae.auction.repository.ProductRepository;
import com.hanghae.auction.repository.UserRepository;
import com.hanghae.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TestDataRunner implements ApplicationRunner {

    @Autowired
    UserService userService;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BidRepository bidRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 테스트 User 생성
        Users testUser = new Users("test1", passwordEncoder.encode("123"));
        Users testUser1 = new Users("test2", passwordEncoder.encode("123"));
        Users testadminUser = new Users("admin", passwordEncoder.encode("123"));
        testUser = userRepository.save(testUser);
        testUser1 = userRepository.save(testUser1);
        testadminUser = userRepository.save(testadminUser);

        // 테스트 User 의 관심상품 등록
        // 검색어 당 관심상품 10개 등록
        createTestData(testUser, "에어팟1", 1022000L, "2020년에 산 것", "2022-06-20-18:00");
        createTestData(testUser, "에어팟2", 1000000L, "2021년에 산 것", "2022-06-21-20:00");
        createTestData(testUser, "에어팟프로", 120000L, "2022년에 산 것", "2022-06-21-18:00");
    }

    private void createTestData(Users user, String searchWord, Long price, String description, String endtime) throws IOException {

        ProductRequestDto requestDto = new ProductRequestDto("/static/images",  searchWord, price, description, endtime);
        Product product = new Product(requestDto, user);

        Product savedProduct = productRepository.save(product);

        Bid bid = new Bid(user, savedProduct, price);
        bidRepository.save(bid);
    }
}