package com.edu.eci.ieti.taskMicroservice.service;

import com.edu.eci.ieti.taskMicroservice.dto.TaskDTO;
import com.edu.eci.ieti.taskMicroservice.entity.Task;
import com.edu.eci.ieti.taskMicroservice.exception.TaskException;

import java.util.List;

public interface TaskService {
    Task create(Task task );

    Task findById( String id );

    List<Task> getAll();

    void deleteById( String id ) throws TaskException;

    Task update( Task task, String id ) throws TaskException;

    List<TaskDTO> convert(List<Task> users);
}
