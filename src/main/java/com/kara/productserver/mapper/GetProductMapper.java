package com.kara.productserver.mapper;

import com.kara.productserver.dto.*;
import com.kara.productserver.entity.Dimensions;
import com.kara.productserver.entity.Inventory;
import com.kara.productserver.entity.Metadata;
import com.kara.productserver.entity.Product;
import com.kara.productserver.entity.enumble.Status;
import com.kara.productserver.service.CategoryService;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class GetProductMapper {
private final CategoryService categoryService; ;

    public GetProductMapper(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //entity to Dto
    public static ProductGetDto map(Product product) {
        if (product == null) {
            return null;
        }
        ProductGetDto dto = new ProductGetDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setSku(product.getSku());
        dto.setCreatedAt(product.getCreatedAt());
        dto.setUpdatedAt(product.getUpdatedAt());
        dto.setDeletedAt(product.getDeletedAt());
        // Category’den sadece name al
        if (product.getCategoryId() != null) {
            dto.setCategoryName(product.getCategoryId().getName());
        }
        // Inventory mapping -> record kullan
        if (product.getInventory() != null) {
            Inventory inv = product.getInventory();
            dto.setInventory(new InventoryDto(
                    inv.getQuantity(),
                    inv.getReserved(),
                    inv.getAvailable()
            ));
        }

        // Metadata mapping -> record kullan
        if (product.getMetadata() != null) {
            Metadata meta = product.getMetadata();
            dto.setMetadata(new MetadataDto(
                    meta.getWeight(),
                    meta.getTags(),
                    meta.getDimensions() != null
                            ? new Dimensions(meta.getDimensions().getWidth(), meta.getDimensions().getHeight(), meta.getDimensions().getDepth())
                            : null
            ));
        }

        return dto;
    }

    public static Product updateToProduct(UpdateProduct product) {
        Product product2 = new Product();
        product2.setStatus(product.getStatus());
        product2.setName(product.getName());
        product2.setDescription(product.getDescription());
        product2.setPrice(product.getPrice());
        product2.setCategoryId(product.getCategoryId());
        product2.setSku(product.getSku());
        product2.setInventory(product.getInventory());
        product2.setMetadata(product.getMetadata());
        product2.setUpdatedAt(OffsetDateTime.now());
        return product2;
    }

    public  Product createProduct(CreateProductDto dto ){
        Product productEntity = new Product();
        Inventory inventoryEntity = new Inventory();
        Metadata metadataEntity = new Metadata();
        metadataEntity.setWeight(dto.getMetadata().weight());
        metadataEntity.setDimensions(dto.getMetadata().dimensions());
        metadataEntity.setTags(dto.getMetadata().tags());
        inventoryEntity.setAvailable(dto.getInventory().available());
        inventoryEntity.setReserved(dto.getInventory().reserved());
        inventoryEntity.setQuantity(dto.getInventory().quantity());
        productEntity.setMetadata(metadataEntity);
        productEntity.setCategoryId(categoryService.getCategory(dto.getCategoryId()));
        productEntity.setInventory(inventoryEntity);
        productEntity.setStatus(Status.ACTIVE);
        productEntity.setName(dto.getName());
        productEntity.setDescription(dto.getDescription());
        productEntity.setPrice(dto.getPrice());
        productEntity.setSku(dto.getSku());
        return productEntity;
    }
}
