package com.kara.productserver.config.kafka;


import com.kara.productserver.dto.InventoryKafka;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, InventoryKafka> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        // Kafka broker adresi
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        // Serializer
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonSerializer.class);
        // Daha detaylı ayarlar
        configProps.put(ProducerConfig.ACKS_CONFIG, "all"); // Mesajın tüm replica’lara yazılmasını bekler
        configProps.put(ProducerConfig.RETRIES_CONFIG, 10); // Başarısız olursa retry sayısı
        configProps.put(ProducerConfig.LINGER_MS_CONFIG, 5); // Mesajları birleştirip geciktirme süresi
        configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, 32*1024); // Batch boyutu (32 KB)
        configProps.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432); // 32 MB buffer
        configProps.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy"); // Mesaj sıkıştırma
        return new DefaultKafkaProducerFactory<>(configProps);
    }
    @Bean
    public KafkaTemplate<String, InventoryKafka> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
