package com.example.pratica_api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    private String description;
    private LocalDate createdAt = LocalDate.now();
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private Status status = Status.TO_DO;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    public enum Status {
        TO_DO, IN_PROGRESS, DONE
    }

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
