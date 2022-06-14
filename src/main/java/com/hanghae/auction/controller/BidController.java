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

    @PostMapping("/price/{pid}")
    public BidPriceRequestDto doBid(@PathVariable Long pid, @AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody BidPriceRequestDto requestDto){
        return bidService.doBid(pid, userDetails.getUser().getId(), requestDto.getPrice());
    }

    @PutMapping("/price/{pid}")
    public BidPriceRequestDto didBid(@PathVariable Long pid, @AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody BidPriceRequestDto requestDto){
        return bidService.doBid(pid, userDetails.getUser().getId(), requestDto.getPrice());
    }

}
