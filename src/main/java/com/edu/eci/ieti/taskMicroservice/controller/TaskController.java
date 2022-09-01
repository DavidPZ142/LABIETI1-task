package com.edu.eci.ieti.taskMicroservice.controller;

import com.edu.eci.ieti.taskMicroservice.dto.TaskDTO;
import com.edu.eci.ieti.taskMicroservice.entity.Task;
import com.edu.eci.ieti.taskMicroservice.exception.TaskException;
import com.edu.eci.ieti.taskMicroservice.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDTO ) {
        ModelMapper modelMapper = new ModelMapper();
        Task task = modelMapper.map(taskDTO,Task.class);
        taskService.create(task);
        return new ResponseEntity<>(taskDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll(){
        return new ResponseEntity<>(taskService.getAll(),HttpStatus.ACCEPTED);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable String id){
        ModelMapper modelMapper = new ModelMapper();
        TaskDTO taskDTO = modelMapper.map(taskService.findById(id), TaskDTO.class);
        return new ResponseEntity<>(taskDTO,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        try{
            taskService.deleteById(id);
            return new ResponseEntity<>("Borrado", HttpStatus.ACCEPTED);
        } catch (TaskException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> update( @RequestBody TaskDTO taskDTO, @PathVariable String id ) {
        ModelMapper modelMapper = new ModelMapper();
        try {
            Task task = modelMapper.map(taskDTO, Task.class);
            taskService.update(task, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (TaskException e) {
            throw new RuntimeException(e);
        }
    }
}

