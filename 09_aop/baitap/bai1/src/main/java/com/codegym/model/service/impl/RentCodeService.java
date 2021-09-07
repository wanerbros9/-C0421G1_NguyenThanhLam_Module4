package com.codegym.model.service.impl;

import com.codegym.model.entity.RentCode;
import com.codegym.model.repository.IRentCodeRepository;
import com.codegym.model.service.IRentCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentCodeService implements IRentCodeService {
    @Autowired
    private IRentCodeRepository rentCodeRepository;


    @Override
    public void save(RentCode rentCode) {
        rentCodeRepository.save(rentCode);
    }

    @Override
    public RentCode findById(Long id) {
        return rentCodeRepository.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        rentCodeRepository.deleteById(id);
    }
}
