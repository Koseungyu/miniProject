package com.hanghae.auction.controller;


import com.hanghae.auction.dto.BidPriceRequestDto;
import com.hanghae.auction.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BidController {
    private final BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping("/price/{pid}")
    public BidPriceRequestDto doBid(@PathVariable Long pid){
        Long uid = 1L;      // TEST
        Long price = 20L;
        return bidService.doBid(pid, uid, price);
    }

    @PutMapping("/price/{pid}")
    public BidPriceRequestDto didBid(@PathVariable Long pid, @RequestBody BidPriceRequestDto requestDto){
        Long uid = 1L;      // TEST
        return bidService.doBid(pid, uid, requestDto.getPrice());
    }

}
