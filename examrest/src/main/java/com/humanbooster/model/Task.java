package com.humanbooster.model;

import java.time.LocalDateTime;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Nullable
    private String description;

    private boolean done;

    private LocalDateTime createdAt;

    @Nullable
    private LocalDateTime updatedAt;

    public Task() {}
    public Task(String nom, String prenom, LocalDateTime updatedAt) {
        this.title = nom;
        this.description = prenom;
        this.done=false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = updatedAt;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return title; }
    public void setNom(String title) { this.title = title; }
    public String getPrenom() { return description; }
    public void setPrenom(String description) { this.description = description; }
    public boolean getDone() { return done; }
    public void setDone(boolean done) { this.done = done; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
} 
