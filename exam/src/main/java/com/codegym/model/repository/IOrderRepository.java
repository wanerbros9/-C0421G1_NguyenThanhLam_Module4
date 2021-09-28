package com.codegym.model.repository;

import com.codegym.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
//    Page<Order> findOrderByDateBuyBetween
}
