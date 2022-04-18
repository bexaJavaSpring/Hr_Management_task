package com.example.hr_management_task.entity;

import com.example.hr_management_task.entity.enums.MonthEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SalaryHistory {
    @Id
    @GeneratedValue
    private UUID id=UUID.randomUUID();
    @ManyToOne
    private Employee employee;
    private Double amount;
    @CreatedDate
    @Column(updatable = false,nullable = false)
    private Date creatTime;
    @Enumerated(EnumType.STRING)
    private MonthEnum monthEnum;


}
