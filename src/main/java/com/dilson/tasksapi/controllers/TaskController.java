package com.dilson.tasksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilson.tasksapi.models.Task;
import com.dilson.tasksapi.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Task task = this.taskService.findById(id);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Task>> findByUserId(@PathVariable Long userId) {
        List<Task> tasks = this.taskService.findByUser(userId);
        return ResponseEntity.ok().body(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {
        Task newTask = this.taskService.create(task);
        return ResponseEntity.ok().body(newTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Task task, @PathVariable Long id) {
        task.setId(id);
        this.taskService.update(task);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
