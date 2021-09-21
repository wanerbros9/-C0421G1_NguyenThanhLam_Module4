package com.codegym.model.service.impl.employee;

import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.repository.employee.IDivisionRepository;
import com.codegym.model.repository.employee.IEducationDegreeRepository;
import com.codegym.model.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void delete(int id) {
        educationDegreeRepository.deleteById(id);
    }

    @Override
    public EducationDegree findById(int id) {
        return educationDegreeRepository.findById(id).get();
    }
}
