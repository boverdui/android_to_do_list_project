package com.codeclan.example.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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

        TextView name = listItemView.findViewById(R.id.textView_name);
        name.setText(currentTask.getName());

        ImageView image = listItemView.findViewById(R.id.imageView_status);
        if (currentTask.getStatus().equals("completed")) {
            image.setImageResource(R.drawable.check);
        }

        listItemView.setTag(currentTask);

        return listItemView;

    }

}
