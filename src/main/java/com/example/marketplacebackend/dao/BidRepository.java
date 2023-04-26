package com.example.marketplacebackend.dao;

import com.example.marketplacebackend.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BidRepository extends JpaRepository<Bid, Long>, QuerydslPredicateExecutor<Bid> {
}
