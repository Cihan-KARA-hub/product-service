package com.kara.productserver.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * DTO for {@link com.kara.productserver.entity.Metadata}
 */
public record MetadataDto(BigDecimal weight, List<String> tags, DimensionsDto dimensionsDto) implements Serializable {

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "weight = " + weight + ", " +
                "tags = " + tags + ", " +
                "dimensionsDto = " + dimensionsDto + ")";
    }
}