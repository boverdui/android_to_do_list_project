package com.codeclan.example.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity {

    TextView nameTextView;
    TextView descriptionTextView;
    TextView statusTextView;
    Task selectedTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Intent intent = getIntent();
        selectedTask = (Task) intent.getSerializableExtra("task");

        nameTextView = (TextView) findViewById(R.id.textView_name);
        nameTextView.setText(selectedTask.getName());

        descriptionTextView = (TextView) findViewById(R.id.textView_description);
        descriptionTextView.setText(selectedTask.getDescription());

        statusTextView = (TextView) findViewById(R.id.textView_status);
        statusTextView.setText(selectedTask.getStatus());

    }

    public void onClickDeleteButton(View view) {

        TaskDbHelper taskDbHelper = new TaskDbHelper(this);

        taskDbHelper.deleteTask(selectedTask);

        finish();

    }

}
