package com.kara.productserver.entity;

import com.kara.productserver.entity.enumble.Status;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID")
    private UUID id;
    private String name;
    private String description;
    @Column(precision = 19, scale = 2)
    private BigDecimal price;
    private String category;
    private String sku;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
    @Embedded
    private Inventory inventory;
    @Embedded
    private Metadata metadata;
    @CreationTimestamp
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    private OffsetDateTime deletedAt;
}