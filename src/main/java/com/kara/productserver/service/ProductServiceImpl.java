package com.kara.productserver.service;

import com.kara.productserver.dto.CreateProductDto;
import com.kara.productserver.dto.InventoryKafka;
import com.kara.productserver.dto.ProductGetDto;
import com.kara.productserver.dto.UpdateProduct;
import com.kara.productserver.entity.Category;
import com.kara.productserver.entity.Inventory;
import com.kara.productserver.entity.Product;
import com.kara.productserver.entity.enumble.Status;
import com.kara.productserver.mapper.GetProductMapper;
import com.kara.productserver.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.kara.productserver.mapper.GetProductMapper.map;
import static com.kara.productserver.mapper.GetProductMapper.updateToProduct;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final GetProductMapper getProductMapper;
    private final KafkaTemplate<String, InventoryKafka> kafkaTemplate;


    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService,
                              GetProductMapper getProductMapper,
                              KafkaTemplate<String, InventoryKafka> kafkaTemplate) {

        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.getProductMapper = getProductMapper;
        this.kafkaTemplate = kafkaTemplate;
    }
    @Override
    public void createProduct(CreateProductDto dto) {
        Product product = getProductMapper.createProduct(dto);
        if (product != null) {
            productRepository.save(product);
        }
    }

    @Override
    public void deleteProduct(UUID productId) {
        Product product = productRepository.findById(productId).orElseThrow(NoSuchElementException::new);
            product.setStatus(Status.DELETE);
            productRepository.save(product);
    }

    @Override
    @Transactional
    public void updateProduct(UUID productId, UpdateProduct product) {
        productRepository.findById(productId).orElseThrow(NoSuchElementException::new);
        productRepository.save(updateToProduct(product));
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
        categoryService.saveCategory(category);
    }

    @Override
    @Transactional
    public Page<ProductGetDto> getPageProducts(Pageable pageable) {
        Page<Product> entityPage = productRepository.findAllProducts(pageable);
        return entityPage.map(GetProductMapper::map);
    }

    @Override
    public ProductGetDto findById(UUID id) {
        Optional<Product> entity = productRepository.findById(id);
        return entity.map(GetProductMapper::map).orElse(null);
    }

    @Override
    @Transactional
    public void updateInventories(UUID id, InventoryKafka dto) {
        Product product = productRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (product != null) {
            Inventory inventory = new Inventory();
            inventory.setQuantity(dto.getQuantity());
            inventory.setReserved(dto.getReserved());
            inventory.setAvailable(dto.getAvailable());
            product.setInventory(inventory);
            product.setInventory(inventory);
            productRepository.save(product);
            // publisher kafka
            kafkaTemplate.send("prod.product.inventory.update", id.toString(), dto);

        }

    }


}