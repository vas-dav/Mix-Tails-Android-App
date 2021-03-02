package com.example.mix_tailsapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context) {
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
        if (db != null) {
            this.db.close();
        }
    }
    // DO NOT TOUCH!!! PLEASE!!!
    // method to query and returning a result from database from drink name limited to 1
    public String getDrink(String inputSpirit, String inputTaste, String inputSize, String inputStrength) {
        String query = "SELECT name FROM cocktails WHERE spirit LIKE '" + inputSpirit
                + "%' AND taste LIKE '" + inputTaste
                + "%' AND size LIKE '" + inputSize
                + "%' AND strength LIKE '" + inputStrength + "%' LIMIT 1";
        c = db.rawQuery(query, null );
        StringBuffer buffer = new StringBuffer();
        if (c.moveToFirst()) {
            do {
                String getName = c.getString(c.getColumnIndex("name"));
                buffer.append(getName);

            } while (c.moveToNext());
        }

        return buffer.toString();
    }

   // Method for getting a random drink from a Database
   public String getRandom(){
        int count = 0;
        c = db.rawQuery("SELECT * FROM cocktails", null);
        if(c.moveToLast()){
            count = c.getCount();
        }
        c.moveToPosition((int) (Math.random() * count));
        String getRandName = c.getString(c.getColumnIndex("name"));
        return getRandName;
   }


}



