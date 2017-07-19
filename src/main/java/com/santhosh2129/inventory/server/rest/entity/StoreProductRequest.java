package com.santhosh2129.inventory.server.rest.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by santhosh on 7/2/17.
 */
public class StoreProductRequest {
    private String name;
    private String category;
    private List<Map<String,String>> price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Map<String,String>> getPrice() {
        return price;
    }

    public void setPrice(List<Map<String,String>> price) {
        this.price = price;
    }

}
