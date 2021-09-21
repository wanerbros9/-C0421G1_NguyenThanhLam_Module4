package com.codegym.model.service.customer;

import com.codegym.model.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {

    List<CustomerType> findAll();

    void save(CustomerType customerType);

    void delete(int id);

    CustomerType findById(int id);
}
