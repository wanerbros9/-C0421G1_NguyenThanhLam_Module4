package com.codegym.model.service.customer;

import com.codegym.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    void save(Customer customer);

    void delete(int id);

    Customer findById(int id);

    Page<Customer> findCustomerByCustomerName (String name, Pageable pageable);

    Page<Customer> findCustomerByCustomerNameContaining (String name, Pageable pageable);
}
