package com.codegym.model.service;

import com.codegym.model.bean.Health;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HealthService implements IHealthService{

    private List<Health> healthList = new ArrayList<>();

    @Override
    public void save(Health health) {
        healthList.add(health);
    }
}
