package com.kara.elasticsearchserver.kafka;

import com.kara.elasticsearchserver.model.ElasticSearchProduct;
import com.kara.elasticsearchserver.model.Message;
import com.kara.elasticsearchserver.repository.ElasticSearchProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class ProductConsumer {
    private final ElasticSearchProductRepository productRepository;
    Logger log = LoggerFactory.getLogger(ProductConsumer.class);

    public ProductConsumer(ElasticSearchProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @KafkaListener(topics = "product.public.product", groupId = "product-group")
    public void DebeziumListener(Message message) {
        ElasticSearchProduct elasticSearchProduct = new ElasticSearchProduct();
        // buraya id set edilecek
        elasticSearchProduct.setId(message.getAfter().getId().toString());
        elasticSearchProduct.setName(message.getAfter().getName());
        elasticSearchProduct.setDescription(message.getAfter().getDescription());
        productRepository.save(elasticSearchProduct);
        log.info("Debezium product saved with id {}", elasticSearchProduct.getId());
        if (message.getOp().equals("d")) {
            productRepository.delete(elasticSearchProduct);
            log.info("Deleted product id={} from Elasticsearch", message.getAfter().getId());
        }
    }
}
