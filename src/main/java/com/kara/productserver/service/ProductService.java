package com.kara.productserver.service;

import com.kara.productserver.dto.ProductGetDto;
import com.kara.productserver.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    void createProduct(Product product);
    void deleteProduct(UUID productId);
    void updateProduct();
    List<ProductGetDto> getProducts();

    void addCategory(String name);
}
