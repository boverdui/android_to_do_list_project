package com.codeclan.example.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity {

    TextView nameTextView;
    TextView descriptionTextView;
    TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Intent intent = getIntent();
        Task selectedTask = (Task) intent.getSerializableExtra("task");

        nameTextView = (TextView) findViewById(R.id.textView_name);
        nameTextView.setText(selectedTask.getName());

        descriptionTextView = (TextView) findViewById(R.id.textView_description);
        descriptionTextView.setText(selectedTask.getDescription());

        statusTextView = (TextView) findViewById(R.id.textView_status);
        statusTextView.setText(selectedTask.getStatus());


    }

}
