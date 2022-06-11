package com.hanghae.auction.controller;


import com.hanghae.auction.service.BidService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BidController {

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    private final BidService bidService;

    @PostMapping("/price/{pid}")
    public Long doBid(@PathVariable Long pid, @RequestBody Long price){
        Long uid = 1L;      // TEST
        return bidService.doBid(pid, uid, price);
    }

    @PutMapping("/price{pid}")
    public Long didBid(@PathVariable Long pid, @RequestBody Long price){
        Long uid = 1L;      // TEST
        return bidService.doBid(pid, uid, price);
    }

}
