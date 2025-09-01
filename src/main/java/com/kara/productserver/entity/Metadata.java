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
    @CollectionTable(
            name = "product_tags",
            joinColumns = @JoinColumn(name = "product_id")
    )
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "tag")
    private List<String> tags;
    @Embedded
    private Dimensions dimensions;
    public Metadata() {
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "id=" + id +
                ", weight=" + weight +
                ", tags=" + tags +
                ", dimensions=" + dimensions +
                '}';
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

