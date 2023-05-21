package com.dilson.tasksapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dilson.tasksapi.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
