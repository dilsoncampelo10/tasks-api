package com.dilson.tasksapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dilson.tasksapi.models.Task;
import com.dilson.tasksapi.models.User;
import com.dilson.tasksapi.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public Task findById(Long id) {
        Optional<Task> task = this.taskRepository.findById(id);

        return task.orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
    }

    public Task create(Task task) {
        User user = this.userService.findById(task.getUser().getId());
        task.setId(null);
        task.setUser(user);
        task = this.taskRepository.save(task);
        return task;
    }

    @Transactional
    public Task update(Task task) {
        Task newTask = findById(task.getId());
        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        return newTask;
    }

    public void delete(Long id){
        findById(id);
        this.taskRepository.deleteById(id);
    }

}
