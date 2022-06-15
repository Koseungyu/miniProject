package com.hanghae.auction.controller;


import com.hanghae.auction.dto.BidPriceRequestDto;
import com.hanghae.auction.security.UserDetailsImpl;
import com.hanghae.auction.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class BidController {
    private final BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping("/price/{pid}/{uid}")
    public BidPriceRequestDto doBid(@PathVariable Long pid, @PathVariable Long uid, @RequestBody BidPriceRequestDto requestDto){
        return bidService.doBid(pid, uid, requestDto.getPrice());
    }

    @PutMapping("/price/{pid}/{uid}")
    public BidPriceRequestDto didBid(@PathVariable Long pid, @PathVariable Long uid, @RequestBody BidPriceRequestDto requestDto){
        return bidService.doBid(pid, uid, requestDto.getPrice());
    }

}
