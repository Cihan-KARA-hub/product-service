package com.kara.productserver.service;

import com.kara.productserver.dto.ProductGetDto;
import com.kara.productserver.entity.Category;
import com.kara.productserver.entity.Product;
import com.kara.productserver.entity.enumble.Status;
import com.kara.productserver.mapper.GetProductMapper;
import com.kara.productserver.repository.CategoryRepository;
import com.kara.productserver.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.kara.productserver.mapper.GetProductMapper.map;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final GetProductMapper getProductMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, GetProductMapper getProductMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.getProductMapper = getProductMapper;
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            product.get().setStatus(Status.DELETE);
            productRepository.save(product.get());
        }
    }

    @Override
    public void updateProduct() {

    }

    @Override
    @Transactional
    public List<ProductGetDto> getProducts() {
        List<Product> product = productRepository.findAll();
        List<ProductGetDto> productGetDtos = new ArrayList<>();
        for (Product p : product) {
            productGetDtos.add(map(p));
        }
        return productGetDtos;
    }

    @Override
    public void addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Page<ProductGetDto> getPageProducts(Pageable pageable) {
        Page<Product> entityPage = productRepository.findAllProducts(pageable);
        Page<ProductGetDto> dtoPage = entityPage.map(GetProductMapper::map);
        return dtoPage;
    }

    @Override
    public ProductGetDto findById(UUID id) {
        Optional<Product> entity = productRepository.findById(id);
        return entity.map(GetProductMapper::map).orElse(null);
    }


}
