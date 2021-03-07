package com.example.mix_tailsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * authors: Vasily, Miguel
 * This class is intended for accessing and inserting the drink database
 */


public class DatabaseAccess {


    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;
    Cursor ingCurs = null;
    Cursor recom = null;

    public static final String DATABASE_NAME = "Drinks.db";
    public static final String TABLE_NAME = "cocktails";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SPIRIT = "spirit";
    public static final String COLUMN_TASTE = "taste";
    public static final String COLUMN_SIZE = "size";
    public static final String COLUMN_STRENGTH = "strength";
    public static final String COLUMN_INGREDIENTS = "ingredients";

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
    /**
     * method to query and returning a result from database from drink name limited to 1
     */

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

    /**
     * create getSimilarDrink method to query and returning a similar result without strength from
     * database from drink name limited to 1
     */

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

    /**
     *  method to query and returning a similar result without size from database from drink name limited to 1
     */

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

    /**
     * method to query and returning a similar result without taste from database from drink name limited to 1
     */

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

    /**
     * Method for getting a random drink from a Database
     */

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

    /**
     * Method for getting ingredients of a drink
     */

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
    /**
     * Method for getting ingredients of a drink only with a name (NOT TESTED)
     */

    public String getDrinkIngs2(String inputName) {
        String getIngs = null;
        String query = "SELECT * FROM cocktails WHERE name LIKE '" + inputName + "%'";
        ingCurs = db.rawQuery(query, null);
        StringBuffer buffer = new StringBuffer();
        if (ingCurs.moveToFirst()) {
                getIngs = ingCurs.getString(6);

        }

        return getIngs;
    }

    public boolean addFavorite(ContentValues contentValues) {
        long executed = 0;
        boolean done = false;
        executed = db.insertOrThrow("favorites", null, contentValues);
        if (executed != -1){
            done = true;
        } else {
            done = false;
        }
        return done;


    }

// Getting an ArrayList of all favourite Drinks
public ArrayList<String> getFavs(){
    String query = "SELECT name FROM cocktails WHERE favs = 1";
    ingCurs = db.rawQuery(query, null);
    ArrayList<String> favList = new ArrayList<String>();
    if (ingCurs.moveToFirst()) {
        do {
            String getFavs = ingCurs.getString(1);
            favList.add(getFavs);

        } while (ingCurs.moveToNext());
    }

    return (favList);
}

//Method for adding a favourite drink or setting it back to not favourite
public boolean setOrResetHeartDrink(int setValue, String inputName){
        boolean result;
        String query = "UPDATE cocktails SET favs = "
                + setValue + " WHERE name LIKE '" + inputName + "%'";
        if((setValue != 1 || setValue != 0)){
            result = false;
        } else {
            db.execSQL(query);
            result = true;
        }
        return result;
}
    //Method for getting a list of Recommended Drinks
    public ArrayList<String> getRecom(){
        ArrayList<String> recomList = new ArrayList<String>();
        int count = 0;
        String selectAll = "SELECT name FROM cocktails";
        recom = db.rawQuery(selectAll, null);
        if (recom.moveToLast()) {
            count = recom.getCount();
        }
        for(int i = 0; i < 8; i++){
            recom.moveToPosition((int) (Math.random() * count));
            recomList.add(recom.getString(1));
            //Changing the drink if random output gave to similar Drinks
            if(recomList.contains(recomList.get(i))){
                recom.moveToPosition((int) (Math.random() * count));
                recomList.add(i, recom.getString(1));
            }
        }
        return (recomList);
    }

    public boolean insertDrink(String name, String spirit, String taste, String size, String strength, String ingredients) {

        db.isOpen();
        ContentValues values = new ContentValues();
        db.beginTransaction();

        values.put(COLUMN_NAME, name);
        values.put(COLUMN_SPIRIT, spirit);
        values.put(COLUMN_TASTE, taste);
        values.put(COLUMN_SIZE, size);
        values.put(COLUMN_STRENGTH, strength);
        values.put(COLUMN_INGREDIENTS, ingredients);

        long rowInserted = db.insert(TABLE_NAME, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();

        if(rowInserted != -1)
            return true;
        else
            return false;


    }

}






