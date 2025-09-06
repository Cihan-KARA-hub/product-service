package com.kara.productserver.dto;

import com.kara.productserver.entity.Category;
import com.kara.productserver.entity.Inventory;
import com.kara.productserver.entity.Metadata;
import com.kara.productserver.entity.enumble.Status;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class UpdateProduct {
    private String name;
    private String description;
    private BigDecimal price;
    private Category categoryId;
    private String sku;
    private Status status = Status.ACTIVE;
    private Inventory inventory;
    private Metadata metadata;
    private OffsetDateTime updatedAt;
    public UpdateProduct() {}
    public UpdateProduct(String name, String description,
                         BigDecimal price, Category categoryId,
                         String sku, Status status, Inventory inventory,
                         Metadata metadata, OffsetDateTime updatedAt) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.sku = sku;
        this.status = status;
        this.inventory = inventory;
        this.metadata = metadata;
        this.updatedAt = updatedAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
