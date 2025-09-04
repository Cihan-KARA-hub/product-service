package com.kara.elasticsearchserver.controller;

import com.kara.elasticsearchserver.model.ElasticSearchProduct;
import com.kara.elasticsearchserver.service.ProductSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class ElasticSearchProductController {
    private final ProductSearchService service;

    public ElasticSearchProductController(ProductSearchService service) {
        this.service = service;
    }

    @GetMapping("/fulltext")
    public List<ElasticSearchProduct> fullTextSearch(@RequestParam String q) {
        return service.fullTextSearch(q);
    }

    @GetMapping("/auto")
    public List<ElasticSearchProduct> autoSearch(@RequestParam String q) {
        return service.autocompleteSearch(q);
    }

}
