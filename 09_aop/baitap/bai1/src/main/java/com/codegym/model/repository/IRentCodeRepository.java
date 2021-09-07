package com.codegym.model.repository;

import com.codegym.model.entity.RentCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentCodeRepository extends JpaRepository<RentCode, Long> {
}
