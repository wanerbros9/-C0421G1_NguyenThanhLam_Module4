package com.codegym.model.service.impl.contract;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.repository.contract.IContractRepository;
import com.codegym.model.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void delete(int id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).get();
    }
}
