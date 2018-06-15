package com.example.pratyush.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="contacts.db";
    private static final String TABLE_NAME="contacts";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,MOBILE TEXT, EMAIL TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String name, String mobile, String email){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("MOBILE", mobile);
        contentValues.put("EMAIL", email);
        long result=db.insert(TABLE_NAME, null,contentValues);
        if (result==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor getData(String mobile){
        SQLiteDatabase db= this.getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_NAME+" WHERE MOBILE='"+mobile+"'";

        Cursor cursor=db.rawQuery(query,null);
        return cursor;

    }
}
