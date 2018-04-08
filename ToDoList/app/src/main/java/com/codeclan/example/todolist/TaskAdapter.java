package com.codeclan.example.todolist;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bert on 27/03/2018.
 */

public class TaskAdapter extends ArrayAdapter<Task> {

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
            super(context, 0, tasks);
}

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {

        Task currentTask = getItem(position);

        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.task_item, parent, false);

        }

        TextView priority = listItemView.findViewById(R.id.textView_priority);

        if (currentTask.getPriority().equals("high")) {
            priority.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.highPriority));
        }
        else if (currentTask.getPriority().equals("medium")) {
            priority.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.mediumPriority));

        }
        else {
            priority.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.lowPriority));
        }

        CheckBox statusCheckBox = listItemView.findViewById(R.id.checkBox_status);

        if (currentTask.getStatus().equals("completed")) {

            statusCheckBox.setChecked(true);
            statusCheckBox.setVisibility(View.VISIBLE);

        } else {

            statusCheckBox.setChecked(false);
            statusCheckBox.setVisibility(View.INVISIBLE);

        }

        TextView name = listItemView.findViewById(R.id.textView_name);

        name.setText(currentTask.getName());

        listItemView.setTag(currentTask);

        return listItemView;

    }

}
