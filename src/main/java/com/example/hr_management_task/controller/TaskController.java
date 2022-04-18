package com.example.hr_management_task.controller;

import com.example.hr_management_task.dto.ApiResponse;
import com.example.hr_management_task.dto.TaskDto;
import com.example.hr_management_task.repository.TaskRepository;
import com.example.hr_management_task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/task")
@RestController
@RequiredArgsConstructor
public class TaskController {

    final TaskRepository taskRepository;
    final TaskService taskService;

    @GetMapping("/list")
    public HttpEntity<?> getAll(){
        return ResponseEntity.ok().body(taskRepository.findAll());
    }
    @PostMapping("/add")
    public HttpEntity<?> add(@Valid @RequestBody TaskDto dto){
        ApiResponse apiResponse=taskService.add(dto);
        return ResponseEntity.status(apiResponse.isActive()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable UUID id,@Valid @RequestBody TaskDto dto){
        ApiResponse apiResponse=taskService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isActive()?200:409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id){
        ApiResponse apiResponse=taskService.delete(id);
        return ResponseEntity.status(apiResponse.isActive()?204:404).body(apiResponse);
    }
}
