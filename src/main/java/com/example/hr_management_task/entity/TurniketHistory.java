package com.example.hr_management_task.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.UUID;

public class TurniketHistory {
    @Id
    @GeneratedValue
    private UUID id = UUID.randomUUID();

    @OneToOne
    private Turniket turniket;

    private boolean entered=false;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp enterTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp exitTime;

}
