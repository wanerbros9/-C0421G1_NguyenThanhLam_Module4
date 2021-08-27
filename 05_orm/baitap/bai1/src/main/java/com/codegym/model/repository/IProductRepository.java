package com.codegym.model.repository;

import com.codegym.model.bean.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(Product product);

    Product findByName(String name);
}
