package com.codegym.model.service;

import com.codegym.model.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {

    Page<Order> findAll(Pageable pageable);

    List<Order> findAll();

    void save(Order order);

    void delete(Long id);

    Order findById(Long id);

//    Page<Order> findCustomerByCustomerNameContaining (String name, Pageable pageable);
}
