package com.codegym.model.service.impl.contract;

import com.codegym.model.entity.contract.AttachService;
import com.codegym.model.repository.contract.IAttachServiceRepository;
import com.codegym.model.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {

    @Autowired
    private IAttachServiceRepository attachServiceRepository;


    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepository.save(attachService);
    }

    @Override
    public void delete(int id) {
        attachServiceRepository.deleteById(id);
    }

    @Override
    public AttachService findById(int id) {
        return attachServiceRepository.findById(id).get();
    }
}
