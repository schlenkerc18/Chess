package com.hfad.chess;

/**
 * Created by Schlenker18 on 12/7/2016.
 */

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

class ChessDatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "chess";  // the name of our database
    public static final int DB_VERSION = 1; // the version of the database
    public static final String Table_Name = "chessTable"; // the name of our table
    public static final String Col_1 = "GAME_ID";
    public static final String Col_2 = "PIECE_ARRAY";
    public static final String Col_3 = "WHITE_TAKEN";
    public static final String Col_4 = "BLACK_TAKEN";
    public static final String Col_5 = "USER";

    ChessDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name + "(" + Col_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Col_2 +" TEXT,"+ Col_3 + " TEXT," + Col_4 + " TEXT, " +Col_5+ " TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(db);
    }

    public boolean insertData(String pieceArray, String whiteTaken, String blackTaken, int saveNum,
                              String usr ) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " +Col_2+ " from " +Table_Name+ " where GAME_ID = '"
                +saveNum+ "'", null);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2, pieceArray);
        contentValues.put(Col_3, whiteTaken);
        contentValues.put(Col_4, blackTaken);
        contentValues.put(Col_5, usr);
        if (saveNum == -1) {
            Log.v("JJJJ", "new save");
            Long result = db.insert(Table_Name, null, contentValues);
        }else{
            //contentValues.put(Col_1, saveNum);
            Log.v("JJJJ", "override save");
            String[] tmp = new String[1];
            tmp[0] = pieceArray;
            db.execSQL("UPDATE " +Table_Name+ " SET " +Col_2+ "='" +pieceArray+ "' WHERE " +Col_1+
                    "='" +saveNum+ "'");
        }
        int result = 0;

        if (result == -1){
            return false;
        }
        else{
            return true;
        }

    }

    public int deleteGame(int saveNum) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Table_Name, " GAME_ID = ?", new String[] {Integer.toString(saveNum)});
    }

    public Cursor getPieceArray(int saveNum){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " +Col_2+ " from " +Table_Name+ " where GAME_ID = " +saveNum, null);
        return res;
    }

    public Cursor getWTaken(int saveNum) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + Col_3 + " from " + Table_Name + " where GAME_ID = " + saveNum, null);
        return res;
    }

    public Cursor getBTaken(int saveNum){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " +Col_4+ " from " +Table_Name+ " where GAME_ID = " +saveNum, null);
        return res;
    }

    public Cursor getGames(){
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor res = db.rawQuery("select " + Col_1 + " from " +Table_Name+ " WHERE USER = " +curUser, null);
        Cursor res = db.rawQuery("select * from " + Table_Name, null);
        return res;
    }

    public Cursor getUserName(int saveNum){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " +Col_5+ " from " +Table_Name+ " where GAME_ID = " +saveNum, null);
        return res;
    }
}
