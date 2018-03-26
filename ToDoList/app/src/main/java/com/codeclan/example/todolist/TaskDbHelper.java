package com.codeclan.example.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by bert on 26/03/2018.
 */

public class TaskDbHelper extends DbHelper {

    public TaskDbHelper (Context context) {
        super(context);
    }

    public void add(Task task) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbContract.Entry.COL_1, task.getName());
        values.put(DbContract.Entry.COL_2, task.getDescription());
        values.put(DbContract.Entry.COL_3, 0);

        db.insert(DbContract.Entry.TABLE_NAME, null, values);

    }

}
