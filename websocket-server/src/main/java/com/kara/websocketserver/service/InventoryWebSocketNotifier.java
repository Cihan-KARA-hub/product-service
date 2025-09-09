package com.kara.websocketserver.service;

import com.kara.websocketserver.dto.Inventory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryWebSocketNotifier {

    private final SimpMessagingTemplate messagingTemplate;

    public InventoryWebSocketNotifier(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void notifyInventoryUpdate(UUID productId, Inventory dto) {
        messagingTemplate.convertAndSend(
                "/topic/inventory-updates/" + productId,
                dto
        );
    }
}