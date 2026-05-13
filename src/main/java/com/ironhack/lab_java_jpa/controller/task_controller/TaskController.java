package com.ironhack.lab_java_jpa.controller.task_controller;

import com.ironhack.lab_java_jpa.model.task_system.BillableTask;
import com.ironhack.lab_java_jpa.model.task_system.InternalTask;
import com.ironhack.lab_java_jpa.model.task_system.Task;
import com.ironhack.lab_java_jpa.service.task_service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task created = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> patchTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.patchTask(id, task)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskService.deleteTask(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/billable")
    public ResponseEntity<List<BillableTask>> getAllBillableTasks() {
        return ResponseEntity.ok(taskService.getAllBillableTasks());
    }

    @GetMapping("/billable/{id}")
    public ResponseEntity<BillableTask> getBillableTaskById(@PathVariable Long id) {
        return taskService.getBillableTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/billable")
    public ResponseEntity<BillableTask> createBillableTask(@RequestBody BillableTask billableTask) {
        BillableTask created = taskService.createBillableTask(billableTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/billable/{id}")
    public ResponseEntity<BillableTask> updateBillableTask(@PathVariable Long id, @RequestBody BillableTask billableTask) {
        return taskService.updateBillableTask(id, billableTask)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/billable/{id}")
    public ResponseEntity<BillableTask> patchBillableTask(@PathVariable Long id, @RequestBody BillableTask billableTask) {
        return taskService.patchBillableTask(id, billableTask)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/internal")
    public ResponseEntity<List<InternalTask>> getAllInternalTasks() {
        return ResponseEntity.ok(taskService.getAllInternalTasks());
    }

    @GetMapping("/internal/{id}")
    public ResponseEntity<InternalTask> getInternalTaskById(@PathVariable Long id) {
        return taskService.getInternalTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/internal")
    public ResponseEntity<InternalTask> createInternalTask(@RequestBody InternalTask internalTask) {
        InternalTask created = taskService.createInternalTask(internalTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/internal/{id}")
    public ResponseEntity<InternalTask> updateInternalTask(@PathVariable Long id, @RequestBody InternalTask internalTask) {
        return taskService.updateInternalTask(id, internalTask)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/internal/{id}")
    public ResponseEntity<InternalTask> patchInternalTask(@PathVariable Long id, @RequestBody InternalTask internalTask) {
        return taskService.patchInternalTask(id, internalTask)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}