package com.example.hr_management_task.controller;

import com.example.hr_management_task.entity.Role;
import com.example.hr_management_task.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/role")
@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping
    public org.springframework.http.HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(roleService.getRole());
    }
    @PostMapping
    public HttpEntity<?> addRole(@RequestParam Role roleName){
        return  ResponseEntity.ok().body(roleService.addRole(roleName));
    }
}
