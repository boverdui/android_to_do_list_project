package com.codeclan.example.todolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bert on 26/03/2018.
 */

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {

        super(context, DbContract.DATABASE_NAME, null, DbContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DbContract.Tasks.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DbContract.Tasks.DELETE_TABLE);
        onCreate(db);

    }

}
