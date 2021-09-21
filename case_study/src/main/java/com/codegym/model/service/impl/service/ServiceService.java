package com.codegym.model.service.impl.service;

import com.codegym.model.repository.service.IServiceRepository;
import com.codegym.model.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public List<com.codegym.model.entity.service.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(com.codegym.model.entity.service.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(int id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public com.codegym.model.entity.service.Service findById(int id) {
        return serviceRepository.findById(id).get();
    }
}
