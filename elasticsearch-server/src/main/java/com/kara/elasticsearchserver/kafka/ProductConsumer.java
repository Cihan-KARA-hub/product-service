package com.kara.elasticsearchserver.kafka;

import com.kara.elasticsearchserver.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class ProductConsumer {
    Logger log = LoggerFactory.getLogger(ProductConsumer.class);

    @KafkaListener(topics = "product.public.product", groupId = "product-group")
    public void DebeziumListener(Message message) {
        if (message.getOp().equals("c")) {
            log.info("ilk mesaj");
        }
        log.info(message.getAfter().getName());

    }
}
