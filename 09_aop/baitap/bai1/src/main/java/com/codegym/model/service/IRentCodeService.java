package com.codegym.model.service;

import com.codegym.model.entity.RentCode;

public interface IRentCodeService {
    void save(RentCode rentCode);

    RentCode findById(Long id);

    void remove(Long id);
}
