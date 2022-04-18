package com.example.hr_management_task.service;

import com.example.hr_management_task.dto.ApiResponse;
import com.example.hr_management_task.entity.Role;
import com.example.hr_management_task.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public ApiResponse getRole() {
        List<Role> roles = roleRepository.findAll();
        return new ApiResponse("mana", true, roles);
    }

    public ApiResponse addRole(@RequestBody Role role) {
        if (roleRepository.existsByName(role.getName())) {
            return new ApiResponse("This role exist", false);
        }
        Role role1 = new Role();
        role1.setName(role.getName());
        Role savedRole = roleRepository.save(role1);
        return new ApiResponse("Role added", true, savedRole);
    }
}
