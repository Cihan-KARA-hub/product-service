package com.kara.productserver.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.kara.productserver.entity.Inventory}
 */
public record InventoryDto(int quantity, int reserved, int available) implements Serializable {

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "quantity = " + quantity + ", " +
                "reserved = " + reserved + ", " +
                "available = " + available + ")";
    }
}