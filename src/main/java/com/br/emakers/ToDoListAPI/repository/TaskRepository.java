package com.br.emakers.ToDoListAPI.repository;

import com.br.emakers.ToDoListAPI.data.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
