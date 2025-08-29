package com.kara.productserver.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Dimensions {
    private Double width;
    private Double height;
    private Double depth;
}
