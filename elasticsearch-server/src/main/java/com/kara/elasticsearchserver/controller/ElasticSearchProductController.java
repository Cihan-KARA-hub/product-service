package com.kara.elasticsearchserver.controller;

import com.kara.elasticsearchserver.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class ElasticSearchProductController {
    private final ProductService productService;

    public ElasticSearchProductController(ProductService productService) {
        this.productService = productService;
    }


}
