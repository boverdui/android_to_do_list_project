package com.codeclan.example.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddTaskActivity extends AppCompatActivity {

    EditText editName, editDescription;
    String name, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editName = (EditText) findViewById(R.id.editText_name);
        editDescription = (EditText) findViewById(R.id.editText_description);
    }

    public void onClickAddButton(View view) {

        name = editName.getText().toString();
        description = editDescription.getText().toString();

        Task task = new Task(name, description);
        TaskDbHelper taskDbHelper = new TaskDbHelper(this);

        if (name.length() == 0 || description.length() == 0) {
            Toast.makeText(this, "You have to fill in both fields!", Toast.LENGTH_LONG).show();
        } else {
            taskDbHelper.addTask(task);
            editName.setText(null);
            editDescription.setText(null);
            Toast.makeText(this, "Your task has been added", Toast.LENGTH_LONG).show();
        }

    }

}
