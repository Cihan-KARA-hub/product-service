package com.kara.productserver.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Metadata {

    /*
    "weight": "decimal",
    "dimensions": "object",
    "tags": "array"
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private BigDecimal weight;
    @ElementCollection
    @CollectionTable(
            name = "product_tags",
            joinColumns = @JoinColumn(name = "product_id")
    )
    @Column(name = "tag")
    private List<String> tags;
    @Embedded
    private Dimensions dimensions;

    public Metadata() {
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }


}

