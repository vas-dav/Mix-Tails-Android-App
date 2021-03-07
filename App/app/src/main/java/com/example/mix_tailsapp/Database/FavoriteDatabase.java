package com.example.mix_tailsapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * Create a databse for favortie cocktail
 * author: Annie
 * @version 1 declare variables and write functions
 */
public class FavoriteDatabase extends SQLiteOpenHelper {
    private static int DB_VERSION = 1;
    private static String DB_NAME = "Drinks.db";
    private static String DRINK_NAME = "name";
    private static String TABLE_NAME = "cocktails";
    private static String DRINK_ID = "id";
    private static String DRINK_IMAGE = "drinkImage";
    private static String FAVORITE_STATUS = "favoriteStatus";
    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + DRINK_ID + " TEXT,"
            + DRINK_NAME + " TEXT," + DRINK_IMAGE + " TEXT," + FAVORITE_STATUS + " TEXT)";

    public FavoriteDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //create an empty table
    public void insertToTable () {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //Create a for loop to go through the cocktails database
        for (int i = 1; i < 121; i++) {
            //contentValues.put(DRINK_ID, i);
            contentValues.put(FAVORITE_STATUS, "0");

            database.insert(TABLE_NAME, null, contentValues);
        }
    } //close insertToTable

    //insert to the databse
    public void insertToDatabase(String drink_name, int drink_image, String favorite_status) {
        SQLiteDatabase database;
        database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
    }
}
