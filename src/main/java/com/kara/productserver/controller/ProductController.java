package com.kara.productserver.controller;


import com.kara.productserver.dto.ProductGetDto;
import com.kara.productserver.entity.Product;
import com.kara.productserver.service.ProductService;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<ProductGetDto> getPageProduct(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.getPageProducts(pageable);

    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductGetDto> getFindAll() {
        return productService.getProducts();

    }

    //GET /api/v1/products/{id} - Kimliğe göre belirli bir ürünü al
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductGetDto getProduct(@PathVariable UUID id) {
        return productService.findById(id);
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
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/add-category/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@PathVariable String name) {
        productService.addCategory(name);
    }
}

//TODO bunlar web soket ile halledilecek
//PUT /api/v1/products/{id} - Mevcut bir ürünü güncelle
//

//PATCH /api/v1/products/{id}/inventories - Envanter seviyelerini güncelle




