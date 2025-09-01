package com.kara.productserver.mapper;

import com.kara.productserver.dto.DimensionsDto;
import com.kara.productserver.dto.InventoryDto;
import com.kara.productserver.dto.MetadataDto;
import com.kara.productserver.dto.ProductGetDto;
import com.kara.productserver.entity.Inventory;
import com.kara.productserver.entity.Metadata;
import com.kara.productserver.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class GetProductMapper {

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
                            ? new DimensionsDto(meta.getDimensions().getWidth(), meta.getDimensions().getHeight(), meta.getDimensions().getDepth())
                            : null
            ));
        }

        return dto;
    }
}
