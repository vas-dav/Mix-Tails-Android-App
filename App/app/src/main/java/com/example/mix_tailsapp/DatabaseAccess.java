package com.example.mix_tailsapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpen(context);

    }
    // for returning the single instance of database
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }
    // to open the database
    public void open() {
        this.db = openHelper.getWritableDatabase();
    }
    // closing the database connection
    public void close() {
        if(db != null) {
            this.db.close();
        }
    }

    // method to query and returning a result from database from drink name
    public String getIngredients(String name) {
        c = db.rawQuery("select ingredients from Drinks table where name = " + name + " ", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()) {
            String ingredients = c.getString(0);
            buffer.append("" + ingredients);

        }
        return buffer.toString();
    }
}
