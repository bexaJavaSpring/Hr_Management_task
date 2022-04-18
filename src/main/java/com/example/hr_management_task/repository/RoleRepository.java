package com.example.hr_management_task.repository;

import com.example.hr_management_task.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    boolean existsByName(String name);

}
