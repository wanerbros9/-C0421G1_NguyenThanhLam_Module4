package com.codegym.model.service.service;

import com.codegym.model.entity.service.Service;

import java.util.List;

public interface IServiceService {
    List<Service> findAll();

    void save(Service service);

    void delete(int id);

    Service findById(int id);
}
