package com.example.mix_tailsapp;
/**
 * Created by Annie on 01/03/2021
 * authors Annie, Miguel, Vasily
 * This class is used to show drink ingredients
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DrinkDetail extends AppCompatActivity {

    // Variable declaration
    DatabaseAccess db;
    private TextView drink_name, show_ingredient;
    private ImageView showGlass;
    Button drinkMe;
    private ImageButton goBack;
    private static final String TAG = "misumisu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_detail);

        DatabaseAccess drinksAccess = DatabaseAccess.getInstance(getApplicationContext());
        drinksAccess.open();

        db = new DatabaseAccess(this);


        //Instantiate variable
        drink_name = findViewById(R.id.drink_name);
        show_ingredient = findViewById(R.id.show_ingredient);
        showGlass = (ImageView) findViewById(R.id.img_drink);

        goBack = findViewById(R.id.gobackBtn);

        //onClickListener for go back button
        goBack.setOnClickListener(view -> goBack.setOnClickListener(v -> {
            Intent backToHome = new Intent(DrinkDetail.this, AppWelcomeScreen.class);
            startActivity(backToHome);
        }));

        drinkMe = findViewById(R.id.add_me_fuel);

        //get Intent and show drink detail
        String drinkName = getIntent().getStringExtra(ChosenDrinkSecondActivity.NAME_KEY);
        drink_name.setText(drinkName);
        String details = getIntent().getStringExtra(ChosenDrinkSecondActivity.DETAIL_KEY);
        show_ingredient.setText(details);
        String whiskey = "Whiskey";
        String rum = "Rum";


        // if/else statements to check for spirit names in the
        // database and assigns each with a drawable/image
        db.open();
        Resources glasses = getResources();
        if (db.getSpitOnly(drinkName).contains("Whiskey")) {
            Log.d("imageset", "SET");
            showGlass.setImageResource(R.drawable.whiskey);
        } else if (db.getSpitOnly(drinkName).contains("Rum")) {
            showGlass.setImageResource(R.drawable.mojito);
        } else if (db.getSpitOnly(drinkName).contains("Tequila")) {
            showGlass.setImageResource(R.drawable.rum_color);
        } else if (db.getSpitOnly(drinkName).contains("Gin")) {
            showGlass.setImageResource(R.drawable.gin);
        } else if (db.getSpitOnly(drinkName).contains("Vodka")) {
            showGlass.setImageResource(R.drawable.vodka);
        } else if (db.getSpitOnly(drinkName).contains("Sparkling wine")) {
            showGlass.setImageResource(R.drawable.pcosecco);
        } else {
            showGlass.setImageResource(R.drawable.cocktail);
        }
        drinkMe.setOnClickListener(v -> {
            Intent getToRecoms = new Intent(DrinkDetail.this, DrinkRecommendationPage.class);
            db.setChosen(drinkName);
            startActivity(getToRecoms);
        });
    }
}
