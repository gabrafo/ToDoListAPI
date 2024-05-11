package com.br.emakers.ToDoListAPI.service;

import com.br.emakers.ToDoListAPI.data.dto.request.TaskRequestDTO;
import com.br.emakers.ToDoListAPI.data.dto.response.TaskResponseDTO;
import com.br.emakers.ToDoListAPI.data.entity.Task;
import com.br.emakers.ToDoListAPI.exceptions.general.EntityNotFoundException;
import com.br.emakers.ToDoListAPI.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<TaskResponseDTO> getAllTasks(){
        List<Task> tasks = taskRepository.findAll();

        return tasks.stream().map(TaskResponseDTO::new).collect(Collectors.toList());
    }

    public TaskResponseDTO getTaskById(Long idTask){
        Task task = getTaskEntityById(idTask);

        return new TaskResponseDTO(task);
    }

    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO){
        Task task = new Task(taskRequestDTO);
        taskRepository.save(task);
        return new TaskResponseDTO(task);
    }

    public TaskResponseDTO updateTaskById(Long idTask, TaskRequestDTO taskRequestDTO){
        Task task = getTaskEntityById(idTask);

        task.setName(taskRequestDTO.name());
        task.setSituation(taskRequestDTO.situation());
        task.setCategory(taskRequestDTO.category());
        taskRepository.save(task);

        return new TaskResponseDTO(task);
    }

    public String deleteTask(Long idTask){
        Task task = getTaskEntityById(idTask);
        taskRepository.delete(task);
        return "Task with ID " + idTask + " was deleted succesfully";
    }

    public Task getTaskEntityById(Long idTask){
        return taskRepository.findById(idTask).orElseThrow(()->new EntityNotFoundException(idTask));
    }
}
