package com.example.app_btl.service.model;

import java.util.List;

public class Welcome {
    private String kind;
    private long totalItems;
    private List<Item> items;

    public String getKind() { return kind; }
    public void setKind(String value) { this.kind = value; }

    public long getTotalItems() { return totalItems; }
    public void setTotalItems(long value) { this.totalItems = value; }

    public List<Item> getItems() { return items; }
    public void setItems(List<Item> value) { this.items = value; }
}