package com.kara.productserver.controller;


import com.kara.productserver.dto.ProductGetDto;
import com.kara.productserver.entity.Product;
import com.kara.productserver.service.ProductService;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //GET /api/v1/products - Sayfalandırmalı tüm ürünleri al
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<ProductGetDto> getPageProduct(Pageable pageable) {
        return null;

    }   @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductGetDto> getFindAll() {
        return productService.getProducts();

    }

    //GET /api/v1/products/{id} - Kimliğe göre belirli bir ürünü al
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductGetDto getProduct(@PathVariable int id) {
        return null;
    }

    //POST /api/v1/products - Yeni bir ürün oluşturun
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product dto) {
        productService.createProduct(dto);
    }

    //DELETE /api/v1/products/{id} - Bir ürünü sil (yumuşak silme tercih edilir)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable int id) {

        return;
    }

    @PostMapping("/add-category/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public void  createCategory(@PathVariable String name){
        productService.addCategory(name);
    }
}
//


//TODO bunlar web soket ile halledilecek
//PUT /api/v1/products/{id} - Mevcut bir ürünü güncelle
//

//
//GET /api/v1/products/search - Ürünleri filtrelerle arayın
//
//PATCH /api/v1/products/{id}/inventories - Envanter seviyelerini güncelle




