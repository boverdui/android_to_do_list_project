package com.codeclan.example.todolist;

import java.io.Serializable;

/**
 * Created by bert on 26/03/2018.
 */

public class Task implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private String status;
    private Integer priority;

    public Task(String name, String description, Integer priority) {

        this.name = name;
        this.description = description;
        this.status = "not completed";
        this.priority = priority;

    }

    public Task(Integer id, String name, String description, String status, Integer priority) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.priority = priority;

    }

    public Integer getId() {

        return this.id;

    }

    public String getName() {

        return this.name;

    }

    public String getDescription() {

        return this.description;

    }

    public String getStatus() {

        return this.status;

    }

    public Integer getPriority() {

        return this.priority;

    }

}
