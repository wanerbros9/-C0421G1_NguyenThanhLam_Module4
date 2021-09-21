package com.codegym.model.service.contract;

import com.codegym.model.entity.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    void delete(int id);

    ContractDetail findById(int id);
}
