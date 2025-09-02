package com.kara.elasticsearchserver.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangeEvent {

    @JsonProperty("before")
    private After before;

    @JsonProperty("after")
    private After after;

    @JsonProperty("source")
    private Source source;

    @JsonProperty("transaction")
    private Object transaction; // null olabilir

    @JsonProperty("op")
    private String op;

    @JsonProperty("ts_ms")
    private Long tsMs;

    @JsonProperty("ts_us")
    private Long tsUs;

    @JsonProperty("ts_ns")
    private Long tsNs;
}