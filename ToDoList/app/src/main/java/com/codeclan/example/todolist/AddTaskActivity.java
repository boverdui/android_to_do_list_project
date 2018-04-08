package com.codeclan.example.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddTaskActivity extends AppCompatActivity {

    EditText editName, editDescription;
    RadioButton radioButtonPriority;
    RadioGroup radioGroupPriority;
    String name, description, priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_task);

        editName = findViewById(R.id.editText_name);
        editDescription = findViewById(R.id.editText_description);
        radioGroupPriority = findViewById(R.id.radioGroup_priority);
        radioGroupPriority.check(R.id.radioButton_low);

    }

    public void onClickAddButton(View view) {

        name = editName.getText().toString();
        description = editDescription.getText().toString();
        radioButtonPriority = findViewById(radioGroupPriority.getCheckedRadioButtonId());
        priority = radioButtonPriority.getText().toString();

        Task task = new Task(name, description, priority);

        TaskDbHelper taskDbHelper = new TaskDbHelper(this);

        if (name.length() == 0) {

            Toast.makeText(this, "Task cannot be empty", Toast.LENGTH_LONG).show();

        } else {

            taskDbHelper.addTask(task);

            editName.setText(null);
            editDescription.setText(null);

            Toast.makeText(this, "Task added", Toast.LENGTH_LONG).show();

        }

    }

}
