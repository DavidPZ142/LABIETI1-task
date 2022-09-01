package com.edu.eci.ieti.taskMicroservice.service;

import com.edu.eci.ieti.taskMicroservice.dto.TaskDTO;
import com.edu.eci.ieti.taskMicroservice.entity.Task;
import com.edu.eci.ieti.taskMicroservice.exception.TaskException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceImpl implements  TaskService{

    HashMap<String,Task> tasks = new HashMap<>();

    @Override
    public Task create(Task task) {
        tasks.put(task.getId(), task);
        return task;

    }

    @Override
    public Task findById(String id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> getAll() {
        List<Task> taskList = new ArrayList<>();
        for(String id: tasks.keySet()){
            taskList.add(tasks.get(id));
        }
        return taskList;
    }

    @Override
    public void deleteById(String id) throws TaskException {
        if(!tasks.containsKey(id)){
            throw new TaskException("No existe ese task");
        }
        tasks.remove(id);
    }

    @Override
    public Task update(Task task, String id) throws TaskException {
        if(!tasks.containsKey(id)){
            throw new TaskException("No existe ese task");
        }
        tasks.remove(id);
        tasks.put(id,task);
        return task;
    }

    @Override
    public List<TaskDTO> convert(List<Task> tasks) {
        ModelMapper modelMapper = new ModelMapper();
        List<TaskDTO> listamapeada = new ArrayList<>();
        for (Task task: tasks){
            TaskDTO taskDTO = modelMapper.map(task,TaskDTO.class);
            listamapeada.add(taskDTO);
        }
        return listamapeada;
    }
}
