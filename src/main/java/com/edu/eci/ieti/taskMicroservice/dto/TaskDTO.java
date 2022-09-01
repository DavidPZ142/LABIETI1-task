package com.edu.eci.ieti.taskMicroservice.dto;

import com.edu.eci.ieti.taskMicroservice.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {
    private String name;
    private String description;
    private Status status;
    private String assignedTo;
    private String dueDate;
}
