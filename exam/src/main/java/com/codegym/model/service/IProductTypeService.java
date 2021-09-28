package com.codegym.model.service;

import com.codegym.model.entity.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductTypeService {
    Page<ProductType> findAll(Pageable pageable);

    List<ProductType> findAll();

    void save(ProductType productType);

    void delete(Long id);

    ProductType findById(Long id);
}
