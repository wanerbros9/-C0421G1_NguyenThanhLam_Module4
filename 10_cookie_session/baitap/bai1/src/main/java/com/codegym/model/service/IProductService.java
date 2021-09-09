package com.codegym.model.service;

import com.codegym.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);

    void delete(Product product);
}
