package com.codeclan.example.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_to_do_list);

    }

    @Override
    public void onResume() {
        super.onResume();

        TaskDbHelper taskDbHelper = new TaskDbHelper(this);
        ArrayList<Task> tasks = taskDbHelper.getAllTasks();

        TaskAdapter taskAdapter = new TaskAdapter(this, tasks);

        ListView listView = findViewById(R.id.listView_tasks);
        listView.setAdapter(taskAdapter);
    }

    public void onListItemClick(View listItem){

        Task selectedTask = (Task) listItem.getTag();

        Intent intent = new Intent(this, TaskActivity.class);
        intent.putExtra("task", selectedTask);

        startActivity(intent);

    }

    public void onClickAddButton(View view){
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }

}
