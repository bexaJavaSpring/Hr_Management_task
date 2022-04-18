package com.example.hr_management_task.controller;

import com.example.hr_management_task.dto.ApiResponse;
import com.example.hr_management_task.dto.CompanyDto;
import com.example.hr_management_task.entity.Company;
import com.example.hr_management_task.repository.CompanyRepository;
import com.example.hr_management_task.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {
    final CompanyRepository companyRepository;
    final CompanyService companyService;

    @GetMapping("/list")
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(companyRepository.findAll());
    }
    @PostMapping("/add")
    public HttpEntity<?> add(@Valid @RequestBody CompanyDto dto){
        ApiResponse apiResponse=companyService.add(dto);
        return ResponseEntity.status(apiResponse.isActive()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@Valid @RequestBody CompanyDto dto){
        ApiResponse apiResponse=companyService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isActive()?200:409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        Optional<Company> byId = companyRepository.findById(id);
        companyRepository.delete(byId.get());
        return ResponseEntity.status(byId.get().isActive()?HttpStatus.NOT_FOUND:HttpStatus.OK).body(byId.get());
    }
}
