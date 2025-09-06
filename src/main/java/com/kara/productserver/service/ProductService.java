package com.kara.productserver.service;

import com.kara.productserver.dto.InventoryDto;
import com.kara.productserver.dto.ProductGetDto;
import com.kara.productserver.dto.UpdateProduct;
import com.kara.productserver.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    void createProduct(Product product);
    void deleteProduct(UUID productId);
    void updateProduct(UUID productId, UpdateProduct product);
    List<ProductGetDto> getProducts();
    void addCategory(String name);
    Page<ProductGetDto> getPageProducts(Pageable pageable);
    ProductGetDto findById(UUID id);
    void updateInventories(UUID id, InventoryDto dto);
}
