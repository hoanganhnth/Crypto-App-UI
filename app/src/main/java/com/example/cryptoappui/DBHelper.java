package com.example.cryptoappui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Login.db";
    public static final String COUNT_USERNAME = "username";
    public static final String COUNT_PASSWORD = "password";
    public static final String TABLE_USERS = "users";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_USERS+  " (" + COUNT_USERNAME + " TEXT primary key, " + COUNT_PASSWORD  + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " +TABLE_USERS);
    }

    public boolean insertData(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COUNT_USERNAME, username);
        values.put(COUNT_PASSWORD, password);
        long newRow = db.insert(TABLE_USERS,null,values);
        if (newRow == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean checkUserName(String userName) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_USERS + " where " + COUNT_USERNAME + " = ?",new String[]{userName});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUserNamePassword(String userName, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_USERS + " where " + COUNT_USERNAME + " = ? and " + COUNT_PASSWORD + " = ?",new String[]{userName,password});

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
