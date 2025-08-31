package com.kara.productserver.service;

import com.kara.productserver.entity.Product;

import java.util.UUID;

public interface ProductService {
    void createProduct(Product product);
    void deleteProduct(UUID productId);
    void updateProduct();

    void addCategory(String name);
}
