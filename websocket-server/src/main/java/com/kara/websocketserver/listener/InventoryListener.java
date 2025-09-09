package com.kara.websocketserver.listener;

import com.kara.websocketserver.dto.Inventory;
import com.kara.websocketserver.service.InventoryWebSocketNotifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryListener {

    private final InventoryWebSocketNotifier notifier;

    public InventoryListener(InventoryWebSocketNotifier notifier) {
        this.notifier = notifier;
    }

    @KafkaListener(topics = "prod.product.inventory.update", groupId = "inventory-service")
    public void consumeInventoryUpdate(@Payload Inventory dto,
                                       @Header(KafkaHeaders.KEY) String productId) {
        UUID id = UUID.fromString(productId);

        notifier.notifyInventoryUpdate(id, dto);

        System.out.println("Inventory event published to WebSocket for product " + id);
    }
}