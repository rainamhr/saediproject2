package com.example.queen.saediproject.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by queen on 11/20/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    static String name = "users";
    static int version = 1;
    String createUserTable = "CREATE TABLE if not exists `user` ( `email` TEXT, `password` TEXT, `firstName` TEXT, `lastName` TEXT, `phone` TEXT, `address1` TEXT, `address2` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT )";


    public DatabaseHelper(Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(createUserTable);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
