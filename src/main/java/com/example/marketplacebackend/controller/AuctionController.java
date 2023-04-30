package com.example.marketplacebackend.controller;

import com.example.marketplacebackend.controller.resolver.annotation.Username;
import com.example.marketplacebackend.controller.response.ErrorResponse;
import com.example.marketplacebackend.dao.AuctionRepository;
import com.example.marketplacebackend.dto.AuctionDto;
import com.example.marketplacebackend.model.Auction;
import com.example.marketplacebackend.model.QAuction;
import com.querydsl.core.BooleanBuilder;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auctions")
public class AuctionController {
    private final AuctionRepository auctionRepository;

    public AuctionController(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @GetMapping
    Page<Auction> getAuctions(Pageable pageable, @RequestParam(required = false) String search) {
        var builder = new BooleanBuilder();
        if(search != null) {
            builder.and(QAuction.auction.title.likeIgnoreCase(search + "%"));
        }
        return auctionRepository.findAll(builder, pageable);
    }

    @PostMapping
    ResponseEntity<?> createAuction(@RequestBody @Valid AuctionDto auctionDto, @Username String username) {
        if(username != null) {
            var auction = new Auction(
                    auctionDto.title(),
                    username,
                    auctionDto.category(),
                    auctionDto.description(),
                    auctionDto.condition());
            auction = auctionRepository.saveAndFlush(auction);
            return ResponseEntity.status(HttpStatus.CREATED).body(auction);
        } else {
            return ErrorResponse.of("Please supply a username with X-Username header!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    ResponseEntity<Auction> getAuction(@PathVariable Long id) {
        return ResponseEntity.of(auctionRepository.findById(id));
    }
}
