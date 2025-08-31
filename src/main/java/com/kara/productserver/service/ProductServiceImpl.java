package com.kara.productserver.service;

import com.kara.productserver.entity.Category;
import com.kara.productserver.entity.Product;
import com.kara.productserver.repository.CategoryRepository;
import com.kara.productserver.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID productId) {

    }

    @Override
    public void updateProduct() {

    }

    @Override
    public void addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
    }
}
