package com.codegym.model.service.impl.service;

import com.codegym.model.entity.service.ServiceType;
import com.codegym.model.repository.service.IServiceTypeRepository;
import com.codegym.model.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {

    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void delete(int id) {
        serviceTypeRepository.deleteById(id);
    }

    @Override
    public ServiceType findById(int id) {
        return serviceTypeRepository.findById(id).get();
    }
}
