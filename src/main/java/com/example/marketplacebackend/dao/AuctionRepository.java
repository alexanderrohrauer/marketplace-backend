package com.example.marketplacebackend.dao;

import com.example.marketplacebackend.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AuctionRepository extends JpaRepository<Auction, Long>, QuerydslPredicateExecutor<Auction> {
}
