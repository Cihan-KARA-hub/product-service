package com.kara.productserver.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Inventory {
    private Integer quantity;
    private Boolean reserved;
    private Boolean available;
}