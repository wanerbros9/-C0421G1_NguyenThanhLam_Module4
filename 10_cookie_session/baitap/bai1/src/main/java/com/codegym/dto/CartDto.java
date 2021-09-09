package com.codegym.dto;

import com.codegym.model.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer currentValue = productMap.get(productDto);
            productMap.put(productDto, currentValue + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }

    public void removeProduct(ProductDto productDto) {
        productMap.remove(productDto);
    }

    public void decreaseProduct(ProductDto productDto) {
        productMap.get(productDto);
        if (!(productMap.get(productDto) <= 1)) {
            productMap.put(productDto, productMap.get(productDto) - 1);
        }
    }

    public Float totalPayment() {
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
