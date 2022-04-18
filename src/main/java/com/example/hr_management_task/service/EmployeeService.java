package com.example.hr_management_task.service;

import com.example.hr_management_task.dto.ApiResponse;
import com.example.hr_management_task.dto.EmployeDto;
import com.example.hr_management_task.entity.Employee;
import com.example.hr_management_task.repository.EmployeeRepository;
import com.example.hr_management_task.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final RoleRepository roleRepository;

    public ApiResponse addManager(EmployeDto dto) {
        String email=dto.getEmail();
        String password=dto.getPassword();
        Integer roleId= dto.getRoleId();
        String username= dto.getUsername();
        if(employeeRepository.existsByUsername(username) || employeeRepository.existsByEmail(email)){
            return new ApiResponse("Something went wrong",false);
        }
        if(roleRepository.existsById(roleId)){
            Employee employee=new Employee();
            employee.setPassword(password);
            employee.setEmail(email);
            employee.setUsername(username);
            employee.setRoles(roleRepository.getById(2));

            Employee save = employeeRepository.save(employee);
            return new ApiResponse("Added",true,save);
        }
        return new ApiResponse("Something went wrong",false);
    }

    public ApiResponse add(EmployeDto dto) {
        if(employeeRepository.existsByUsername(dto.getUsername())){
            return new ApiResponse("username already exist",false);
        }
        Employee employee=new Employee();
        employee.setUsername(dto.getUsername());
        employee.setEmail(dto.getEmail());
        employee.setPassword(dto.getPassword());
        Employee save = employeeRepository.save(employee);
        return new ApiResponse("Added",true,save);
    }
}
