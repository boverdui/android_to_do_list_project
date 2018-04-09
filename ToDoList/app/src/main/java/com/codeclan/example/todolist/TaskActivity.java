package com.codeclan.example.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TaskActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText descriptionEditText;
    CheckBox statusCheckBox;
    RadioButton radioButtonPriority;
    RadioGroup radioGroupPriority;

    Task selectedTask;

    Integer id, priority;
    String name, description, status, priority_text;

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

        if (selectedTask.getDescription().equals("")) {
            descriptionEditText.setHint(R.string.hint_description);
        }

        radioGroupPriority = findViewById(R.id.radioGroup_priority);

        if (selectedTask.getPriority().equals(1)) {
            radioGroupPriority.check(R.id.radioButton_high);
        }
        else if (selectedTask.getPriority().equals(2)) {
            radioGroupPriority.check(R.id.radioButton_medium);
        }
        else {
            radioGroupPriority.check(R.id.radioButton_low);
        }

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

        radioButtonPriority = findViewById(radioGroupPriority.getCheckedRadioButtonId());
        priority_text = radioButtonPriority.getText().toString();

        if (priority_text.equals("high")) {

            priority = 1;

        } else if (priority_text.equals("medium")) {

            priority = 2;

        } else {

            priority = 3;

        }

        if (statusCheckBox.isChecked()) {

            status = "completed";

        }
        else {

            status = "not completed";

        }

        Task task = new Task(id, name, description, status, priority);

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
