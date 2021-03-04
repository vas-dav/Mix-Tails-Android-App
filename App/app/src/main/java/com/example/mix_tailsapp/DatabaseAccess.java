package com.example.mix_tailsapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;
    Cursor ingCurs = null;

    public DatabaseAccess(Context context) {
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
        String getName = null;
        String query = "SELECT name FROM cocktails WHERE spirit LIKE '" + inputSpirit
                + "%' AND taste LIKE '" + inputTaste
                + "%' AND size LIKE '" + inputSize
                + "%' AND strength LIKE '" + inputStrength + "%' LIMIT 1";
        c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
                getName = c.getString(c.getColumnIndex("name"));
        }

        return getName;
    }
    // method to query and returning a similar result without strength from database from drink name limited to 1
    public String getSimilarDrinkwOstr(String inputSpirit, String inputTaste, String inputSize) {
        String getName = null;
        String query = "SELECT name FROM cocktails WHERE spirit LIKE '" + inputSpirit
                + "%' AND taste LIKE '" + inputTaste
                + "%' AND size LIKE '" + inputSize
                + "%' LIMIT 1";
        c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
                getName = c.getString(c.getColumnIndex("name"));

        }

        return getName;
    }
    // method to query and returning a similar result without size from database from drink name limited to 1
    public String getSimilarDrinkwOsize(String inputSpirit, String inputTaste, String inputStrength) {
        String getName = null;
        String query = "SELECT name FROM cocktails WHERE spirit LIKE '" + inputSpirit
                + "%' AND taste LIKE '" + inputTaste
                + "%' AND strength LIKE '" + inputStrength
                + "%' LIMIT 1";
        c = db.rawQuery(query, null);
        if (c.moveToFirst()) {

                getName = c.getString(c.getColumnIndex("name"));

        }

        return getName;
    }
    // method to query and returning a similar result without taste from database from drink name limited to 1
    public String getSimilarDrinkwOtaste(String inputSpirit, String inputSize, String inputStrength) {
        String getName = null;
        String query = "SELECT name FROM cocktails WHERE spirit LIKE '" + inputSpirit
                + "%' AND size LIKE '" + inputSize
                + "%' AND strength LIKE '" + inputStrength
                + "%' LIMIT 1";
        c = db.rawQuery(query, null);
        if (c.moveToFirst()) {

            getName = c.getString(c.getColumnIndex("name"));

        }

        return getName;
    }



    // Method for getting a random drink from a Database
    public String getRandom() {
        int count = 0;
        c = db.rawQuery("SELECT * FROM cocktails", null);
        if (c.moveToLast()) {
            count = c.getCount();
        }
        c.moveToPosition((int) (Math.random() * count));
        String getRandName = c.getString(c.getColumnIndex("name"));
        return getRandName;
    }

    // Method for getting ingredients of a drink
    public String getDrinkIngs(String inputSpirit, String inputTaste, String inputSize, String inputStrength) {
        String query = "SELECT * FROM cocktails WHERE spirit LIKE '" + inputSpirit
                + "%' AND taste LIKE '" + inputTaste
                + "%' AND size LIKE '" + inputSize
                + "%' AND strength LIKE '" + inputStrength + "%'";
        ingCurs = db.rawQuery(query, null);
        StringBuffer buffer = new StringBuffer();
        if (ingCurs.moveToFirst()) {
            do {
                String getIngs = ingCurs.getString(6);
                buffer.append(getIngs);

            } while (ingCurs.moveToNext());
        }

        return buffer.toString();
    }
    // Method for getting ingredients of a drink only with a name (NOT TESTED)
    public String getDrinkIngs2(String inputName) {
        String query = "SELECT * FROM cocktails WHERE name LIKE '" + inputName + "%'";
        ingCurs = db.rawQuery(query, null);
        StringBuffer buffer = new StringBuffer();
        if (ingCurs.moveToFirst()) {
            do {
                String getIngs = ingCurs.getString(6);
                buffer.append(getIngs);

            } while (ingCurs.moveToNext());
        }

        return buffer.toString();
    }

}






