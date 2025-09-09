package com.kara.productserver.dto;

import com.kara.productserver.entity.enumble.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class CreateProductDto {
    @NotBlank(message = "not Empty")
    private String name;
    @NotBlank(message = "not Empty")
    private String description;
    @Min(value = 1, message = "price min 1.")
    @Positive(message = "price is positive")
    private BigDecimal price;
    @NotBlank(message = "not Empty")
    private Integer categoryId;
    private String sku;
    private Status status = Status.DISABLED;
    @Valid
    private InventoryDto inventory;
    @Valid
    private MetadataDto metadata;

    public CreateProductDto(String name,
                            String description,
                            BigDecimal price,
                            Integer categoryId,
                            String sku, Status status,
                            InventoryDto inventory,
                            MetadataDto metadata) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.sku = sku;
        this.status = status;
        this.inventory = inventory;
        this.metadata = metadata;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public InventoryDto getInventory() {
        return inventory;
    }

    public void setInventory(InventoryDto inventory) {
        this.inventory = inventory;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }

}
