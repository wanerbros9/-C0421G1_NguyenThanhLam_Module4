package com.codegym.model.service.impl.service;

import com.codegym.model.entity.service.RentType;
import com.codegym.model.repository.service.IRentTypeRepository;
import com.codegym.model.service.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void delete(int id) {
        rentTypeRepository.deleteById(id);
    }

    @Override
    public RentType findById(int id) {
        return rentTypeRepository.findById(id).get();
    }
}
