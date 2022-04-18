package com.example.hr_management_task.repository;

import com.example.hr_management_task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    boolean findByDescription(String name);
}
