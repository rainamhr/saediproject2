package com.example.queen.saediproject.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by queen on 11/20/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "Users";
    private static String TABLE_NAME1 = "user";
    private static String TABLE_NAME2 = "userProfile";
    private static int version = 1;
    private String createUserTable = "CREATE TABLE if not exists `user` (  `id` INTEGER PRIMARY KEY AUTOINCREMENT ,`email` TEXT, `password` TEXT)";
    private String createProfileTable = "CREATE TABLE if not exists `userProfile` ( `fName` TEXT, `lName` TEXT, `phone` TEXT, `address1` TEXT, `address2` TEXT)";

    private static final String Col0 = "id";
    private static final String Col1 = "email";
    private static final String Col2 = "password";
    private static final String Col3 = "fName";
    private static final String Col4 = "lName";
    private static final String Col5 = "address1";
    private static final String Col6 = "address2";
    private static final String Col7 = "phone";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME , null, version);
        getWritableDatabase().execSQL(createUserTable);
        getWritableDatabase().execSQL(createProfileTable);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE if not exists `userProfile` ( `fName` TEXT, `lName` TEXT, `phone` TEXT, `address1` TEXT, `address2` TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE if not exists `user` (  `id` INTEGER PRIMARY KEY AUTOINCREMENT ,`email` TEXT, `password` TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP IF TABLE EXISTS" +TABLE_NAME1);
        sqLiteDatabase.execSQL("DROP IF TABLE EXISTS" +TABLE_NAME2);
        onCreate(sqLiteDatabase);
    }

    public boolean addData(String email,String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Col1, email);
        cv.put(Col2, password);
        long result =  sqLiteDatabase.insert(TABLE_NAME1,null,cv);

        Log.d("adding data", "to table");
        if (result==-1){
                return false;
            }else {
                return true;
            }
    }

    public boolean addProfile(String fName, String lName, String address1, String address2, String phone){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Col3,fName);
        cv.put(Col4,lName);
        cv.put(Col5,address1);
        cv.put(Col6,address2);
        cv.put(Col7,phone);
        long result = db.insert(TABLE_NAME2,null,cv);

        if (result==-1){
            return false;
        }else {
            return true;
        }
    }

    /*public Cursor getData(){
        SQLiteDatabase database = this.getWritableDatabase();
        String QueryUser = "SELECT * FROM" + TABLE_NAME1;
        Cursor dataUser = database.rawQuery(QueryUser, null);
        return dataUser;
    }*/

    public Cursor getProfile(){
        SQLiteDatabase database = this.getWritableDatabase();
        String QueryProfile = ("SELECT* fROM" +TABLE_NAME2);
        Cursor dataUser = database.rawQuery(QueryProfile, null);
        return dataUser;
    }
}

