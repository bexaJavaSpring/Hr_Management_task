package com.example.hr_management_task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {
    private String message;
    private boolean active;
    private Object object;


    public ApiResponse(String message, boolean active) {
        this.message = message;
        this.active = active;
    }
}
