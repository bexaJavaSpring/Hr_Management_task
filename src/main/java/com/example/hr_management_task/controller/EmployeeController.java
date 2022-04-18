package com.example.hr_management_task.controller;

import com.example.hr_management_task.dto.ApiResponse;
import com.example.hr_management_task.dto.EmployeDto;
import com.example.hr_management_task.repository.EmployeeRepository;
import com.example.hr_management_task.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    final EmployeeRepository employeeRepository;
     final EmployeeService employeeService;
    @GetMapping("/list")
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(employeeRepository.findAll());
    }

    @PreAuthorize("hasAuthority('DIRECTOR')")
    @PostMapping("/addManager")
    public HttpEntity<?> addManager(EmployeDto dto){
        ApiResponse apiResponse=employeeService.addManager(dto);
        return ResponseEntity.status(apiResponse.isActive()?201:409).body(apiResponse);
    }
    @PostMapping("/add")
    public HttpEntity<?> add(@Valid @RequestBody EmployeDto dto){
        return ResponseEntity.ok().body(employeeService.add(dto));
    }

}
