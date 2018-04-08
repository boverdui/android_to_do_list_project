package com.codeclan.example.todolist;

import android.provider.BaseColumns;

/**
 * Created by bert on 26/03/2018.
 */

public final class DbContract {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "todolist.db";

    private DbContract() {}

    public static abstract class Tasks implements BaseColumns {

        public static final String TABLE_TASKS = "tasks";
        public static final String COL_NAME = "name";
        public static final String COL_DESCRIPTION = "description";
        public static final String COL_STATUS = "status";
        public static final String COL_PRIORITY = "priority";



        public static final String CREATE_TABLE =
                "CREATE TABLE " + Tasks.TABLE_TASKS + " (" +
                        Tasks._ID + " INTEGER PRIMARY KEY," +
                        Tasks.COL_NAME + " TEXT," +
                        Tasks.COL_DESCRIPTION + " TEXT," +
                        Tasks.COL_STATUS + " TEXT," +
                        Tasks.COL_PRIORITY + " TEXT)";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + Tasks.TABLE_TASKS;

    }

}
