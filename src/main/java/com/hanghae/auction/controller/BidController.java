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

    @PostMapping("/bid/{pid}/{uid}")
    public BidPriceRequestDto doBid(@PathVariable Long pid, @PathVariable Long uid, @RequestBody BidPriceRequestDto requestDto){
        return bidService.doBid(pid, uid, requestDto.getPrice());
    }

    @PutMapping("/bid/{pid}/{uid}")
    public BidPriceRequestDto didBid(@PathVariable Long pid, @PathVariable Long uid, @RequestBody BidPriceRequestDto requestDto){
        return bidService.doBid(pid, uid, requestDto.getPrice());
    }


    @GetMapping("/bid/{pid}")
    public Long getBidCount(@PathVariable Long pid){
        return bidService.getBidCount(pid);
    }
}
