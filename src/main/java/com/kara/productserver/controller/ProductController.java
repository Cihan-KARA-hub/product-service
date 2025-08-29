package com.kara.productserver.controller;

import com.kara.productserver.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/product")
public class ProductController {


    //GET /api/v1/products - Sayfalandırmalı tüm ürünleri al
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<ProductDto> getPageProduct(Pageable pageable) {
        return null;

    }

    //GET /api/v1/products/{id} - Kimliğe göre belirli bir ürünü al
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto getProduct(@PathVariable int id) {
        return null;
    }

    //POST /api/v1/products - Yeni bir ürün oluşturun
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDto dto) {

        return;
    }

    //DELETE /api/v1/products/{id} - Bir ürünü sil (yumuşak silme tercih edilir)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable int id) {

        return;
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




