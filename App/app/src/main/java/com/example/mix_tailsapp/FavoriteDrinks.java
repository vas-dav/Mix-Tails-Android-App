package com.example.mix_tailsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class FavoriteDrinks extends SQLiteAssetHelper {

    public static final String DATABASE_NAME = "Drinks.db";
    public static final String TABLE_NAME = "FAVORITES";

    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "DRINK_NAME";
    public static final String COLUMN_SPIRIT = "DRINK_SPIRIT";
    public static final String COLUMN_TASTE = "DRINK_TASTE";
    public static final String COLUMN_SIZE = "DRINK_SIZE";
    public static final String COLUMN_STRENGTH = "DRINK_STRENGTH";
    public static final String COLUMN_INGREDIENTS = "DRINK_INGREDIENTS";


    public FavoriteDrinks(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    // this is called the first time a database is accessed.
    @Override
    public void newTable(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, "
                + COLUMN_SPIRIT + " TEXT, " + COLUMN_TASTE + " TEXT, "
                + COLUMN_SIZE + " TEXT, " + COLUMN_STRENGTH + " TEXT, " + COLUMN_INGREDIENTS);
    }

    // this is called if the database version number changes
    // it also prevents previous users apps from breaking when changing the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public boolean addFavorite(Integer id, String name, String spirit, String taste, String size, String strength, String ingredients) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues.put(COLUMN_ID, id);
        ContentValues.put(COLUMN_NAME, name);
        ContentValues.put(COLUMN_SPIRIT, spirit);
        ContentValues.put(COLUMN_TASTE, taste);
        ContentValues.put(COLUMN_SIZE, size);
        ContentValues.put(COLUMN_STRENGTH, strength);
        ContentValues.put(COLUMN_INGREDIENTS, ingredients);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }


}
