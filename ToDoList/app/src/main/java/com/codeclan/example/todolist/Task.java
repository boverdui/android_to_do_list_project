package com.codeclan.example.todolist;

import java.io.Serializable;

/**
 * Created by bert on 26/03/2018.
 */

public class Task implements Serializable {

    private int id;
    private String name;
    private String description;
    private int completed;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCompleted() {
        return completed;
    }

}
