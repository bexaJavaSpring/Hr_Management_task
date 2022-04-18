package com.example.hr_management_task.service;

import com.example.hr_management_task.dto.ApiResponse;
import com.example.hr_management_task.dto.TaskDto;
import com.example.hr_management_task.entity.Employee;
import com.example.hr_management_task.entity.Task;
import com.example.hr_management_task.entity.enums.TaskState;
import com.example.hr_management_task.repository.EmployeeRepository;
import com.example.hr_management_task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class TaskService {

    final TaskRepository taskRepository;
    final EmployeeRepository employeeRepository;

    public ApiResponse add(TaskDto dto) {
        boolean byDescription = taskRepository.findByDescription(dto.getDescription());
        if(!byDescription){
            return new ApiResponse("Xatolik",false);
        }
        Task task=new Task();
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        task.setState(TaskState.NEW);
        task.setEndTime(Timestamp.from(Instant.ofEpochMilli(10000)));
        List<Employee> allById = employeeRepository.findAllById(dto.getEmployeeIds());
        task.setEmployeeList(allById);
        Task save = taskRepository.save(task);
        return new ApiResponse("Added",true,save);
    }

    public ApiResponse edit(UUID id, TaskDto dto) {
        Optional<Task> byId = taskRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Task task = byId.get();
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        task.setEndTime(Timestamp.from(Instant.ofEpochMilli(20000)));
        List<Employee> allById = employeeRepository.findAllById(dto.getEmployeeIds());
        task.setEmployeeList(allById);
        Task save = taskRepository.save(task);
        return new ApiResponse("Edited",true,save);
    }

    public ApiResponse delete(UUID id) {
        Optional<Task> byId = taskRepository.findById(id);
        Task task = byId.get();
        task.setCompleted(false);
        taskRepository.save(task);
        return new ApiResponse("Bloced",true);
    }
}
