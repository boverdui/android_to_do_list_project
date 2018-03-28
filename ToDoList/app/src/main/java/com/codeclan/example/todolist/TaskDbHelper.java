package com.codeclan.example.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by bert on 26/03/2018.
 */

public class TaskDbHelper extends DbHelper {

    public TaskDbHelper (Context context) {
        super(context);
    }

    public void addTask(Task task) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentvalues = new ContentValues();

        contentvalues.put(DbContract.Tasks.COL_NAME, task.getName());
        contentvalues.put(DbContract.Tasks.COL_DESCRIPTION, task.getDescription());
        contentvalues.put(DbContract.Tasks.COL_STATUS, task.getStatus());

        db.insert(DbContract.Tasks.TABLE_TASKS,null, contentvalues);

    }

    public ArrayList<Task> getAllTasks() {

        SQLiteDatabase db = this.getWritableDatabase();

        String[] projection = {
                DbContract.Tasks._ID,
                DbContract.Tasks.COL_NAME,
                DbContract.Tasks.COL_DESCRIPTION,
                DbContract.Tasks.COL_STATUS
        };

        Cursor cursor = db.query(
                DbContract.Tasks.TABLE_TASKS, projection,null,null,null,null,null
        );


        ArrayList<Task> tasks = new ArrayList<>();

        if (cursor.moveToFirst()) do {

            Integer idIndex = cursor.getColumnIndex(DbContract.Tasks._ID);
            Integer id = cursor.getInt(idIndex);

            Integer nameIndex = cursor.getColumnIndex(DbContract.Tasks.COL_NAME);
            String name = cursor.getString(nameIndex);

            Integer descriptionIndex = cursor.getColumnIndex(DbContract.Tasks.COL_DESCRIPTION);
            String description = cursor.getString(descriptionIndex);

            Integer statusIndex = cursor.getColumnIndex(DbContract.Tasks.COL_STATUS);
            String status = cursor.getString(statusIndex);

            Task task = new Task(id, name, description, status);

            tasks.add(task);

        } while (cursor.moveToNext());

        cursor.close();

        return tasks;

    }

    public void deleteTask(Task task) {

        SQLiteDatabase db = this.getWritableDatabase();

        String whereClause = DbContract.Tasks._ID + " = ?";
        String[] whereArgs = { task.getId().toString() };

        db.delete(DbContract.Tasks.TABLE_TASKS, whereClause, whereArgs);

    }

    public void updateTask(Task task) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DbContract.Tasks._ID, task.getId());
        contentValues.put(DbContract.Tasks.COL_NAME, task.getName());
        contentValues.put(DbContract.Tasks.COL_DESCRIPTION, task.getDescription());
        contentValues.put(DbContract.Tasks.COL_STATUS, task.getStatus());

        String whereClause = DbContract.Tasks._ID + " = ?";

        String[] whereArgs = { task.getId().toString() };

        db.update(DbContract.Tasks.TABLE_TASKS, contentValues, whereClause, whereArgs);

    }

}
