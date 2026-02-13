package com.example.itemapi.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class ItemResponse {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private String category;

    private Instant createdAt;

    public ItemResponse() {
    }

    public ItemResponse(Long id, String name, String description,
                        BigDecimal price, String category, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
