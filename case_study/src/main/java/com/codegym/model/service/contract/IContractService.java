package com.codegym.model.service.contract;

import com.codegym.model.entity.contract.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();

    void save(Contract contract);

    void delete(int id);

    Contract findById(int id);
}
