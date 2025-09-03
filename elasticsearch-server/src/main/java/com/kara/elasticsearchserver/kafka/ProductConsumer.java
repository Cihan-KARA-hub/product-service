package com.kara.elasticsearchserver.kafka;

import com.kara.elasticsearchserver.model.ElasticSearchProduct;
import com.kara.elasticsearchserver.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class ProductConsumer {
    private final ElasticsearchTemplate elasticsearchTemplate;
    Logger log = LoggerFactory.getLogger(ProductConsumer.class);

    public ProductConsumer(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    @KafkaListener(topics = "product.public.product", groupId = "product-group")
    public void DebeziumListener(Message message) {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        elasticSearchProduct.setName(message.getAfter().getName());
        elasticSearchProduct.setDescription(message.getAfter().getDescription());
        elasticsearchTemplate.save(elasticSearchProduct);
        log.info("Debezium product saved with id {}", elasticSearchProduct.getId());
    }
}
