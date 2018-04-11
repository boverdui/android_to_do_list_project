package com.codeclan.example.todolist;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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

        confirmDialog();

    }

    private void confirmDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to delete this task?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int id) {
                TaskDbHelper taskDbHelper = new TaskDbHelper(getApplicationContext());
                taskDbHelper.deleteTask(selectedTask);
                Toast.makeText(getApplicationContext(), "Task deleted", Toast.LENGTH_LONG).show();
                finish();

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                Toast.makeText(getApplicationContext(), "Task not deleted", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        builder.show();
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
