package com.ironhack.lab_java_jpa.service.task_service;

import com.ironhack.lab_java_jpa.model.task_system.BillableTask;
import com.ironhack.lab_java_jpa.model.task_system.InternalTask;
import com.ironhack.lab_java_jpa.model.task_system.Task;
import com.ironhack.lab_java_jpa.repository.task_system.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> updateTask(Long id, Task task) {
        Optional<Task> existing = taskRepository.findById(id);
        if (existing.isPresent()) {
            Task t = existing.get();
            t.setTitle(task.getTitle());
            t.setDueDate(task.getDueDate());
            t.setCompleted(task.getCompleted());
            return Optional.of(taskRepository.save(t));
        }
        return Optional.empty();
    }

    public Optional<Task> patchTask(Long id, Task task) {
        Optional<Task> existing = taskRepository.findById(id);
        if (existing.isPresent()) {
            Task t = existing.get();
            if (task.getTitle() != null) t.setTitle(task.getTitle());
            if (task.getDueDate() != null) t.setDueDate(task.getDueDate());
            if (task.getCompleted() != null) t.setCompleted(task.getCompleted());
            return Optional.of(taskRepository.save(t));
        }
        return Optional.empty();
    }

    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<BillableTask> getAllBillableTasks() {
        return taskRepository.findAll().stream()
                .filter(t -> t instanceof BillableTask)
                .map(t -> (BillableTask) t)
                .toList();
    }

    public Optional<BillableTask> getBillableTaskById(Long id) {
        return taskRepository.findById(id)
                .filter(t -> t instanceof BillableTask)
                .map(t -> (BillableTask) t);
    }

    public BillableTask createBillableTask(BillableTask billableTask) {
        return taskRepository.save(billableTask);
    }

    public Optional<BillableTask> updateBillableTask(Long id, BillableTask billableTask) {
        Optional<BillableTask> existing = getBillableTaskById(id);
        if (existing.isPresent()) {
            BillableTask b = existing.get();
            b.setTitle(billableTask.getTitle());
            b.setDueDate(billableTask.getDueDate());
            b.setCompleted(billableTask.getCompleted());
            b.setHourlyRate(billableTask.getHourlyRate());
            return Optional.of((BillableTask) taskRepository.save(b));
        }
        return Optional.empty();
    }

    public Optional<BillableTask> patchBillableTask(Long id, BillableTask billableTask) {
        Optional<BillableTask> existing = getBillableTaskById(id);
        if (existing.isPresent()) {
            BillableTask b = existing.get();
            if (billableTask.getTitle() != null) b.setTitle(billableTask.getTitle());
            if (billableTask.getDueDate() != null) b.setDueDate(billableTask.getDueDate());
            if (billableTask.getCompleted() != null) b.setCompleted(billableTask.getCompleted());
            if (billableTask.getHourlyRate() != null) b.setHourlyRate(billableTask.getHourlyRate());
            return Optional.of((BillableTask) taskRepository.save(b));
        }
        return Optional.empty();
    }

    public List<InternalTask> getAllInternalTasks() {
        return taskRepository.findAll().stream()
                .filter(t -> t instanceof InternalTask)
                .map(t -> (InternalTask) t)
                .toList();
    }

    public Optional<InternalTask> getInternalTaskById(Long id) {
        return taskRepository.findById(id)
                .filter(t -> t instanceof InternalTask)
                .map(t -> (InternalTask) t);
    }

    public InternalTask createInternalTask(InternalTask internalTask) {
        return taskRepository.save(internalTask);
    }

    public Optional<InternalTask> updateInternalTask(Long id, InternalTask internalTask) {
        Optional<InternalTask> existing = getInternalTaskById(id);
        if (existing.isPresent()) {
            InternalTask i = existing.get();
            i.setTitle(internalTask.getTitle());
            i.setDueDate(internalTask.getDueDate());
            i.setCompleted(internalTask.getCompleted());
            return Optional.of((InternalTask) taskRepository.save(i));
        }
        return Optional.empty();
    }

    public Optional<InternalTask> patchInternalTask(Long id, InternalTask internalTask) {
        Optional<InternalTask> existing = getInternalTaskById(id);
        if (existing.isPresent()) {
            InternalTask i = existing.get();
            if (internalTask.getTitle() != null) i.setTitle(internalTask.getTitle());
            if (internalTask.getDueDate() != null) i.setDueDate(internalTask.getDueDate());
            if (internalTask.getCompleted() != null) i.setCompleted(internalTask.getCompleted());
            return Optional.of((InternalTask) taskRepository.save(i));
        }
        return Optional.empty();
    }
}