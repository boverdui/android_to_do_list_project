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

    public Task(String name, String description) {

        this.name = name;
        this.description = description;
        this.status = "not completed";

    }

    public Task(Integer id, String name, String description, String status) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;

    }

    public Integer getId() {

        return id;

    }

    public String getName() {

        return name;

    }

    public String getDescription() {

        return description;

    }

    public String getStatus() {

        return status;

    }

}
