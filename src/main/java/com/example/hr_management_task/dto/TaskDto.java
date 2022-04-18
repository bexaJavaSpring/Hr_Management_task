package com.example.hr_management_task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {
    private String name;
    private String description;
    private boolean completed;
    private List<UUID> employeeIds;
}
