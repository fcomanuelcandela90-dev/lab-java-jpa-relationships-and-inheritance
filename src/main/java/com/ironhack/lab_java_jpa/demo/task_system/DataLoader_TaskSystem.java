package com.ironhack.lab_java_jpa.demo.task_system;

import com.ironhack.lab_java_jpa.model.task_system.BillableTask;
import com.ironhack.lab_java_jpa.model.task_system.InternalTask;
import com.ironhack.lab_java_jpa.repository.task_system.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
@Component
public class DataLoader_TaskSystem implements CommandLineRunner {

    private final TaskRepository taskRepository;

    public DataLoader_TaskSystem(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading Task System data...");

        InternalTask task1 = new InternalTask();
        task1.setTitle("--- DEMO TASK: Updating server Java 25 ---");
        task1.setDueDate(LocalDate.now().plusDays(5));
        task1.setCompleted(false);

        BillableTask task2 = new BillableTask();
        task2.setTitle("--- DEMO TASK: Coding the new Java 26 ---");
        task2.setDueDate(LocalDate.now().plusDays(10));
        task2.setCompleted(false);
        task2.setHourlyRate(new BigDecimal("120.50"));

        BillableTask task3 = new BillableTask();
        task3.setTitle("--- DEMO TASK: Updating server Java 26 ---");
        task3.setDueDate(LocalDate.now().plusDays(20));
        task3.setCompleted(false);
        task3.setHourlyRate(new BigDecimal("95.50"));

        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);

        System.out.println("Task System data saved successfully.");
    }
}
