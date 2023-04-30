package com.example.marketplacebackend.controller;

import com.example.marketplacebackend.controller.resolver.annotation.Username;
import com.example.marketplacebackend.controller.response.ErrorResponse;
import com.example.marketplacebackend.dao.AuctionRepository;
import com.example.marketplacebackend.dao.BidRepository;
import com.example.marketplacebackend.dto.BidDto;
import com.example.marketplacebackend.model.Bid;
import com.example.marketplacebackend.model.QBid;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bids")
public class BidController {
    private final BidRepository bidRepository;
    private final AuctionRepository auctionRepository;

    public BidController(BidRepository bidRepository,
                         AuctionRepository auctionRepository) {
        this.bidRepository = bidRepository;
        this.auctionRepository = auctionRepository;
    }

    @GetMapping
    Page<Bid> getBids(Pageable pageable, @RequestParam Long auctionIdEq){
        var filter = QBid.bid.auction.id.eq(auctionIdEq);
        return bidRepository.findAll(filter, pageable);
    }

    @PostMapping
    ResponseEntity<?> addBid(@RequestBody @Valid BidDto bidDto, @Username String username) {
        if(username != null) {
            var auction = auctionRepository.findById(bidDto.auctionId()).orElseThrow();
            var bid = new Bid(username, bidDto.price(), auction);
            bid = bidRepository.saveAndFlush(bid);
            return ResponseEntity.status(HttpStatus.CREATED).body(bid);
        } else {
            return ErrorResponse.of("Please supply a username with X-Username header!", HttpStatus.BAD_REQUEST);
        }
    }
}
