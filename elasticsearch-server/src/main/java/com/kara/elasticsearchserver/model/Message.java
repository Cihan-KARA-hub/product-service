package com.kara.elasticsearchserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
    @JsonProperty("after")
    private After after;
    @JsonProperty("changeEvent")
    private ChangeEvent changeEvent;
    @JsonProperty("transaction")
    private Object transaction;
    @JsonProperty("op")
    private String op;
    @JsonProperty("ts_ms")
    private Long ts_ms;

    public Message(After after, ChangeEvent changeEvent, Object transaction, String op, Long ts_ms) {
        this.after = after;
        this.changeEvent = changeEvent;
        this.transaction = transaction;
        this.op = op;
        this.ts_ms = ts_ms;
    }

    public Message() {
    }

    public ChangeEvent getChangeEvent() {
        return changeEvent;
    }

    public void setChangeEvent(ChangeEvent changeEvent) {
        this.changeEvent = changeEvent;
    }

    public After getAfter() {
        return after;
    }

    public void setAfter(After after) {
        this.after = after;
    }

    public Object getTransaction() {
        return transaction;
    }

    public void setTransaction(Object transaction) {
        this.transaction = transaction;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Long getTs_ms() {
        return ts_ms;
    }

    public void setTs_ms(Long ts_ms) {
        this.ts_ms = ts_ms;
    }

}
