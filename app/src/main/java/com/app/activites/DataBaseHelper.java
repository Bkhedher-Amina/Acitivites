package com.app.activites;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(@Nullable Context context) {
        super(context, "login,db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("Create table user(email text primary key ,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("drop table if exists user ");
    }
    //insertion dans la BD
    public boolean insert(){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put("email","email");
        contentValues.put("password","password");

        long ins= db.insert("user",null,contentValues);
        return ins != -1;
    }

    // vérification l'existance de l'email
    public boolean chkemail(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from user where email=?",new String[]{email});
        return cursor.getCount() <= 0;
    }

    // check the email and password
    public boolean EmailPassword(String email, String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from user where email=?",new String[]{email,password});
        return cursor.getCount() <= 0;

    }
}









