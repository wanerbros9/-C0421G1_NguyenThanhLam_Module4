package com.codegym.model.service.impl.customer;


import com.codegym.model.entity.customer.CustomerType;
import com.codegym.model.repository.customer.ICustomerTypeRepository;
import com.codegym.model.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void delete(int id) {
        customerTypeRepository.deleteById(id);
    }

    @Override
    public CustomerType findById(int id) {
        return customerTypeRepository.findById(id).get();
    }
}
