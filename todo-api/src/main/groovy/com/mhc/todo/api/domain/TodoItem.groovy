package com.mhc.todo.api.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generate by db
    private Long id
    private String description
    private boolean completed

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }

    boolean getCompleted() {
        return completed
    }

    void setCompleted(boolean completed) {
        this.completed = completed
    }
}
