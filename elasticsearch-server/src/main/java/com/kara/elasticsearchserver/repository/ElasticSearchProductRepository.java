package com.kara.elasticsearchserver.repository;

import com.kara.elasticsearchserver.model.ElasticSearchProduct;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ElasticSearchProductRepository extends ElasticsearchRepository<ElasticSearchProduct, UUID> {
}
