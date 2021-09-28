package com.codegym.model.service;

import com.codegym.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    List<Product> findAll();

    void save(Product product);

    void delete(Long id);

    Product findById(Long id);
}
