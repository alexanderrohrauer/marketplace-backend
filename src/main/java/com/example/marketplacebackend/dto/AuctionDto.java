package com.example.marketplacebackend.dto;

import com.example.marketplacebackend.model.Category;
import com.example.marketplacebackend.model.ItemCondition;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.marketplacebackend.model.Auction} entity
 */
public record AuctionDto(@NotNull String title, @NotNull Category category, String description,
                         @NotNull ItemCondition condition) implements Serializable {
}
