package com.codegym.dto;

import com.codegym.model.entity.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Set;

public class OrderDto {
    private Long id;
    @NotEmpty(message = "Buy date must not be empty")
    private LocalDate buyDate;
    @Min(value = 1, message = "Quantity must be positive")
    private int quantity;
    private Set<Product> product;
}
