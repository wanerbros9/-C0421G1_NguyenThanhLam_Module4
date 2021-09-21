package com.codegym.model.service.impl.contract;

import com.codegym.model.entity.contract.ContractDetail;
import com.codegym.model.repository.contract.IContractDetailRepository;
import com.codegym.model.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(int id) {
        contractDetailRepository.deleteById(id);
    }

    @Override
    public ContractDetail findById(int id) {
        return contractDetailRepository.findById(id).get();
    }
}
