package com.codegym.model.repository.customer;

import com.codegym.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findCustomerByCustomerName (String name, Pageable pageable);

    Page<Customer> findCustomerByCustomerNameContaining (String name, Pageable pageable);
}
