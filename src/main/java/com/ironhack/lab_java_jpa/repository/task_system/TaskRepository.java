package com.ironhack.lab_java_jpa.repository.task_system;

import com.ironhack.lab_java_jpa.model.task_system.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>
{
}
