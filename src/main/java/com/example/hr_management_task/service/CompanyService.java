package com.example.hr_management_task.service;

import com.example.hr_management_task.dto.ApiResponse;
import com.example.hr_management_task.dto.CompanyDto;
import com.example.hr_management_task.entity.Company;
import com.example.hr_management_task.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    final CompanyRepository companyRepository;

    public ApiResponse add(CompanyDto dto) {
        Company company=new Company();
        company.setName(dto.getName());
        company.setActive(dto.isActive());
        companyRepository.save(company);
        return new ApiResponse("Added",true);
    }

    public ApiResponse edit(Integer id, CompanyDto dto) {
        Optional<Company> byId = companyRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Company company = byId.get();
        company.setName(dto.getName());
        company.setActive(dto.isActive());
        companyRepository.save(company);
        return new ApiResponse("Edited",true);
    }
}
