package com.example.hr_management_task.repository;

import com.example.hr_management_task.entity.Turniket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TurniketRepository extends JpaRepository<Turniket, UUID> {
}
