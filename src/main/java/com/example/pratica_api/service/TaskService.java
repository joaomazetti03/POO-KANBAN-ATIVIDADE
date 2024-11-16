package com.example.pratica_api.service;

import com.example.pratica_api.model.Task;
import com.example.pratica_api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(Long id, Task taskDetails){
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setPriority(taskDetails.getPriority());
        task.setDueDate(taskDetails.getDueDate());
        return taskRepository.save(task);
    }

    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }

    public Task moveTask(long id){
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
        switch (task.getStatus()){
            case TO_DO -> task.setStatus(Task.Status.IN_PROGRESS);
            case IN_PROGRESS -> task.setStatus(Task.Status.DONE);
            default -> throw new RuntimeException("Task status not supported");
        }
        return taskRepository.save(task);
    }
}
