package com.kara.productserver.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.kara.productserver.entity.Dimensions}
 */
public class DimensionsDto implements Serializable {
    private final Double width;
    private final Double height;
    private final Double depth;

    public DimensionsDto(Double width, Double height, Double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getDepth() {
        return depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DimensionsDto entity = (DimensionsDto) o;
        return Objects.equals(this.width, entity.width) &&
                Objects.equals(this.height, entity.height) &&
                Objects.equals(this.depth, entity.depth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, depth);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "width = " + width + ", " +
                "height = " + height + ", " +
                "depth = " + depth + ")";
    }
}