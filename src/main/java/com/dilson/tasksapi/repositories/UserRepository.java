package com.dilson.tasksapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dilson.tasksapi.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
