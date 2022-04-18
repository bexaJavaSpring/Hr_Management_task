package com.example.hr_management_task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeDto {
    private String username;
    private String password;
    private String email;
    private Integer roleId;

    public EmployeDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
