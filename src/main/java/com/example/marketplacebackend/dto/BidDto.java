package com.example.marketplacebackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.marketplacebackend.model.Bid} entity
 */
public record BidDto(@NotNull @Positive Double price, @NotNull Long auctionId) implements Serializable {
}
