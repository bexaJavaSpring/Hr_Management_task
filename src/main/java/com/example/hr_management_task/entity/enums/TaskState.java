package com.example.hr_management_task.entity.enums;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public enum TaskState {
    NEW,
    RUNNING,
    ENDED
}
