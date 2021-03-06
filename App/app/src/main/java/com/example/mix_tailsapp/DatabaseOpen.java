package com.example.mix_tailsapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * authors: Vasily, Miguel
 * Getting the database opened
 */
public class DatabaseOpen extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "Drinks.db";
    private static final int DATABASE_VERSION = 2;


    public  DatabaseOpen(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);
    }


}
