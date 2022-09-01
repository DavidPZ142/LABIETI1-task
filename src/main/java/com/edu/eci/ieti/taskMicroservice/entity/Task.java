package com.edu.eci.ieti.taskMicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Task {
    private String id;
    private String name;
    private String description;
    private Status status;
    private String assignedTo;
    private String dueDate;
    private String createdAt;

    public Task(){
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDate.now().toString();
    }

}
