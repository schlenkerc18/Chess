package com.hfad.chess;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Schlenker18 on 12/14/2016.
 */

class LogInDatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "logIn";  // the name of our database
    public static final int DB_VERSION = 1; // the version of the database
    public static final String Table_Name = "usnmPswd"; // the name of our table
    public static final String Col_1 = "USR_ID";
    public static final String Col_2 = "USR_NAME";
    public static final String Col_3 = "PASSWORD";

    LogInDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name + "(" + Col_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Col_2 +" TEXT,"+ Col_3 +  " TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(db);
    }

    public boolean registerUsr(String userNam, String passWord) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2, userNam);
        contentValues.put(Col_3, passWord);
        Long result = db.insert(Table_Name, null, contentValues);
        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor logIn(String userNam) {
        //String tmp = null;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " +Col_3+ " from " +Table_Name
                + " where " +Col_2+ " = '" +userNam+ "'", null);
        //Intent intent = new Intent(LogInDatabaseHelper.this, LogInScreen.class);
        //tmp = res.getString(0);
        Log.v("LogIn query", "coMPLETE");
        return res;
    }

    public int deleteData(String userNam) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Table_Name, " USR_NAME = ?", new String[] {userNam});
    }

    public Cursor getUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + Table_Name, null);
        return res;
    }

}
