package com.example.hr_management_task.repository;

import com.example.hr_management_task.entity.SalaryHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalaryHistoryRepository extends JpaRepository<SalaryHistory, UUID> {
}
