package com.kara.websocketserver.dto;

public class Inventory {
    /*
    "quantity": "integer",
    "reserved": "integer",
    "available": "integer"
     */
    private int quantity = 0;
    private int reserved;
    private int available;

    public Inventory(int quantity, int reserved, int available) {
        this.quantity = quantity;
        this.reserved = reserved;
        this.available = available;
    }
    public Inventory() {
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}

