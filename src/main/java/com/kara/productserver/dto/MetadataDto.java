package com.kara.productserver.dto;

import com.kara.productserver.entity.Dimensions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * DTO for {@link com.kara.productserver.entity.Metadata}
 */
public record MetadataDto(BigDecimal weight,
                          List<String> tags,
                          Dimensions dimensions) implements Serializable {

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "weight = " + weight + ", " +
                "tags = " + tags + ", " +
                "dimensionsDto = " + dimensions + ")";
    }
}