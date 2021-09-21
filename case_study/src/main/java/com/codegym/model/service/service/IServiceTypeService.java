package com.codegym.model.service.service;

import com.codegym.model.entity.service.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAll();

    void save(ServiceType serviceType);

    void delete(int id);

    ServiceType findById(int id);
}
