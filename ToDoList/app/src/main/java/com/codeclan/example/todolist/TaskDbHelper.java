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

        ContentValues values = new ContentValues();

        values.put(DbContract.Entry.COL_1, task.getName());
        values.put(DbContract.Entry.COL_2, task.getDescription());
        values.put(DbContract.Entry.COL_3, task.getStatus());

        db.insert(DbContract.Entry.TABLE_NAME, null, values);

    }

    public ArrayList<Task> getAllTasks() {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + DbContract.Entry.TABLE_NAME,null);

        ArrayList<Task> tasks = new ArrayList<>();

        if (cursor.moveToFirst()) do {

            Integer idIndex = cursor.getColumnIndex(DbContract.Entry._ID);
            Integer id = cursor.getInt(idIndex);

            Integer nameIndex = cursor.getColumnIndex(DbContract.Entry.COL_1);
            String name = cursor.getString(nameIndex);

            Integer descriptionIndex = cursor.getColumnIndex(DbContract.Entry.COL_2);
            String description = cursor.getString(descriptionIndex);

            Integer statusIndex = cursor.getColumnIndex(DbContract.Entry.COL_3);
            String status = cursor.getString(statusIndex);

            Task task = new Task(id, name, description, status);

            tasks.add(task);

        } while (cursor.moveToNext());

        cursor.close();

        return tasks;

    }

    public void deleteTask(Task task) {

        SQLiteDatabase db = this.getWritableDatabase();

        String whereClause = DbContract.Entry._ID + " = ?";
        String[] whereArgs = { task.getId().toString() };

        db.delete(DbContract.Entry.TABLE_NAME, whereClause, whereArgs);

    }

    public void updateTask(Task task) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DbContract.Entry._ID, task.getId());
        contentValues.put(DbContract.Entry.COL_1, task.getName());
        contentValues.put(DbContract.Entry.COL_2, task.getDescription());
        contentValues.put(DbContract.Entry.COL_3, task.getStatus());

        String whereClause = DbContract.Entry._ID + " = ?";
        String[] whereArgs = { task.getId().toString() };

        db.update(DbContract.Entry.TABLE_NAME, contentValues, whereClause, whereArgs);

    }

}
