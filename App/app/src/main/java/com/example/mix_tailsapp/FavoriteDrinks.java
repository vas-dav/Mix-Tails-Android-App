package com.example.mix_tailsapp;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * authors: Miguel, Vasily
 * This class is intended for the user to add favorite drink
 * in a new table of the app database(Drinks.db)
 */

public class FavoriteDrinks {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static FavoriteDrinks instance;
    Cursor c = null;

    public FavoriteDrinks(Context context) {
        this.openHelper = new DatabaseOpen(context);

    }

    // for returning the single instance of database
    public static FavoriteDrinks getInstance(Context context) {
        if (instance == null) {
            instance = new FavoriteDrinks(context);
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

    public boolean addFavorite(String id, String name, String spirit, String ingredients) {
        boolean executed = false;
        String FaveQuery = " INSERT INTO favorites(id, name, spirit, ingredients) " +
                "SELECT id, name, spirit, ingredients FROM cocktails";
        db.execSQL(FaveQuery, new String[]{id, name, spirit, ingredients});
        executed = true;
        return executed;


    }


}
