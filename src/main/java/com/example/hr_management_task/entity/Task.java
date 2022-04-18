package com.example.hr_management_task.entity;

import com.example.hr_management_task.entity.enums.TaskState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Task {
    @Id
    @GeneratedValue
    private UUID id=UUID.randomUUID();
    @Column(unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskState state=TaskState.NEW;
    private boolean completed=false;
    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    private Timestamp creatTime;
    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp endTime;

    @OneToMany
    private List<Employee> employeeList;


}
