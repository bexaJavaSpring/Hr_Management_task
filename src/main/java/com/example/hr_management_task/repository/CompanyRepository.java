package com.example.hr_management_task.repository;

import com.example.hr_management_task.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    boolean existsByName(String name);
}
