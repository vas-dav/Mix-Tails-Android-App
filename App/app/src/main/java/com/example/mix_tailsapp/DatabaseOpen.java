package com.example.mix_tailsapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.mix_tailsapp.Database.Cocktails;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;
/**
 * Create a database class for the app
 * authors: Annie, Vasily, Miguel
 * @version 1: Getting the database opened (Miguel)
 * @version 2: Adding onUpgrade method (Miguel)
 * @version 2.1: Adding (3) functions to get cocktail name from database (Annie)
 * References:
 * https://www.youtube.com/watch?v=rziyVBKEU50&t=1000s
 * https://www.youtube.com/watch?v=rziyVBKEU50&t=1000s
 * Reference for drinks:
 * Alcoholic
 * https://makecocktailsathome.com/wp-content/uploads/2012/07/MakeCocktailsAtHome-Cocktail-List-20121.pdf
 * Non-alcoholic
 * https://www.townandcountrymag.com/leisure/drinks/how-to/g785/best-mocktail-recipes/
 * https://www.gvsu.edu/cms4/asset/1C54986C-CFEC-38E9-B36C92CEAE343FBC/mocktails_booklet.pdfhttps://www.gvsu.edu/cms4/asset/1C54986C-CFEC-38E9-B36C92CEAE343FBC/mocktails_booklet.pdf
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

    /*
    Writing functions for searchBar in DrinkRecommendationPage Activity (Annie)
    */
    // searching through database to get all cocktails

    public List<Cocktails> getCocktails() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        String[] selectSql = {"id", "name", "spirit", "taste", "size", "strength", "ingredients"};
        String tableName = "cocktails";
        queryBuilder.setTables(tableName);
        Cursor cursor = queryBuilder.query(db, selectSql, null, null, null, null, null);
        List<Cocktails> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Cocktails cocktails = new Cocktails();
                cocktails.setId(cursor.getInt(cursor.getColumnIndex("id")));
                cocktails.setName(cursor.getString(cursor.getColumnIndex("name")));
                cocktails.setSpirit(cursor.getString(cursor.getColumnIndex("spirit")));
                cocktails.setTaste(cursor.getString(cursor.getColumnIndex("taste")));
                cocktails.setSize(cursor.getString(cursor.getColumnIndex("size")));
                cocktails.setStrength(cursor.getString(cursor.getColumnIndex("strength")));
                cocktails.setIngredients(cursor.getString(cursor.getColumnIndex("ingredients")));
                result.add(cocktails);
            }  while (cursor.moveToNext());
        }
        return result;
    }

    // function to get all cocktails names in the search bar
    public List<String> getDrinkName() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        String[] selectSql = {"name"};
        String tableName = "cocktails";

        queryBuilder.setTables(tableName);
        Cursor cursor = queryBuilder.query(db, selectSql, null, null, null, null, null);
        List<String> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                result.add(cursor.getString(cursor.getColumnIndex("name")));
            }  while (cursor.moveToNext());
        }
        return result;
    }

    // function to get cocktail by name and ingredients in the adapter
    public List<Cocktails> getDrinkByName(String name) {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        String[] selectSql = {"id", "name", "ingredients"};
        String tableName = "cocktails";
        queryBuilder.setTables(tableName);

        Cursor cursor = queryBuilder.query(db, selectSql, "name AND ingredients LIKE ?",
                new String[] {"%"+name+ "%"}, null, null, null);
        List<Cocktails> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Cocktails cocktails = new Cocktails();
                cocktails.setId(cursor.getInt(cursor.getColumnIndex("id")));
                cocktails.setName(cursor.getString(cursor.getColumnIndex("name")));
                cocktails.setIngredients(cursor.getString(6));
                result.add(cocktails);
            }  while (cursor.moveToNext())   ;
        }
        return result;
    }


}
