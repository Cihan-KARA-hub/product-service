package com.kara.elasticsearchserver.service;

import com.kara.elasticsearchserver.model.ElasticSearchProduct;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSearchService {
    private final ElasticsearchOperations elasticsearchOperations;

    public ProductSearchService(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public List<ElasticSearchProduct> fullTextSearch(String keyword) {
        NativeQuery query = NativeQuery.builder()
                .withQuery(q -> q
                        .multiMatch(m -> m
                                .fields("name", "description")
                                .query(keyword)
                                .fuzziness("AUTO")
                        )
                )
                .build();

        SearchHits<ElasticSearchProduct> hits =
                elasticsearchOperations.search(query, ElasticSearchProduct.class);

        return hits.stream()
                .map(SearchHit::getContent)
                .toList();
    }

    public List<ElasticSearchProduct> autocompleteSearch(String keyword) {
        NativeQuery query = NativeQuery.builder()
                .withQuery(q -> q
                        .matchPhrasePrefix(m -> m
                                .field("name")
                                .query(keyword)
                        )
                )
                .build();

        SearchHits<ElasticSearchProduct> hits =
                elasticsearchOperations.search(query, ElasticSearchProduct.class);

        return hits.stream()
                .map(SearchHit::getContent)
                .toList();
    }

    public List<ElasticSearchProduct> wildcardSearch(String keyword) {
        NativeQuery query = NativeQuery.builder()
                .withQuery(q -> q
                        .wildcard(w -> w
                                .field("name.keyword")
                                .wildcard("*" + keyword.toLowerCase() + "*")
                        )
                )
                .build();

        SearchHits<ElasticSearchProduct> hits =
                elasticsearchOperations.search(query, ElasticSearchProduct.class);

        return hits.stream()
                .map(SearchHit::getContent)
                .toList();
    }

}
