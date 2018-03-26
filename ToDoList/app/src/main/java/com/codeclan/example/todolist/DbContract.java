package com.codeclan.example.todolist;

import android.provider.BaseColumns;

/**
 * Created by bert on 26/03/2018.
 */

public final class DbContract {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "todolist.db";

    private DbContract() {}

    public static abstract class Entry implements BaseColumns {

        public static final String TABLE_NAME = "tasks";

        public static final String COL_1 = "name";
        public static final String COL_2 = "description";
        public static final String COL_3 = "completed";


        public static final String CREATE_TABLE =
                "CREATE TABLE " + Entry.TABLE_NAME + " (" +
                        Entry._ID + " INTEGER PRIMARY KEY," +
                        Entry.COL_1 + " TEXT," +
                        Entry.COL_2 + " TEXT," +
                        Entry.COL_3 + " INTEGER)";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + Entry.TABLE_NAME;

    }

}
