package com.codeclan.example.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class TaskActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText descriptionEditText;
    CheckBox statusCheckBox;
    Task selectedTask;

    Integer id;
    String name, description, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Intent intent = getIntent();
        selectedTask = (Task) intent.getSerializableExtra("task");

        nameEditText = findViewById(R.id.editText_name);
        nameEditText.setText(selectedTask.getName());

        descriptionEditText = findViewById(R.id.editText_description);
        descriptionEditText.setText(selectedTask.getDescription());

        statusCheckBox = findViewById(R.id.checkBox_status);
        if (selectedTask.getStatus().equals("completed")) {
            statusCheckBox.setChecked(true);
        } else {
            statusCheckBox.setChecked(false);
        }

    }

    public void onClickDeleteButton(View view) {

        TaskDbHelper taskDbHelper = new TaskDbHelper(this);

        taskDbHelper.deleteTask(selectedTask);

        Toast.makeText(this, "Task deleted", Toast.LENGTH_LONG).show();

        finish();

    }

    public void onClickUpdateButton(View view) {

        id = selectedTask.getId();
        name = nameEditText.getText().toString();
        description = descriptionEditText.getText().toString();
        if (statusCheckBox.isChecked()) {
            status = "completed";
        }
        else {
            status = "not completed";
        }

        Task task = new Task(id, name, description, status);

        TaskDbHelper taskDbHelper = new TaskDbHelper(this);

        if (name.length() == 0) {
            Toast.makeText(this, "Task cannot be empty", Toast.LENGTH_LONG).show();
        } else {
            taskDbHelper.updateTask(task);
            Toast.makeText(this, "Task updated", Toast.LENGTH_LONG).show();
            finish();
        }

    }

}
