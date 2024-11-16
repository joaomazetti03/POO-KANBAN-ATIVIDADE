package com.example.pratica_api.repository;

import com.example.pratica_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
