package com.codegym.model.service.service;


import com.codegym.model.entity.service.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();

    void save(RentType rentType);

    void delete(int id);

    RentType findById(int id);
}
