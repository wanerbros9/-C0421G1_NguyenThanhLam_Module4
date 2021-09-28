package com.codegym.dto;

import com.codegym.model.entity.Order;
import com.codegym.model.entity.ProductType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class ProductDto {
    private Long id;
    @NotEmpty(message = "Name must not empty")
    private String name;
    @Min(value = 1, message = "Price must be positive")
    private double price;
    private String status;
    private ProductType productType;
    private Order order;
}
