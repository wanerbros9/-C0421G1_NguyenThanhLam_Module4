package com.codegym.model.service.contract;

import com.codegym.model.entity.contract.AttachService;

import java.util.List;

public interface IAttachServiceService {
    List<AttachService> findAll();

    void save(AttachService attachService);

    void delete(int id);

    AttachService findById(int id);
}
