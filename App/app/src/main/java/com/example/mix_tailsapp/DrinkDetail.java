package com.example.mix_tailsapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * Created by Annie on 01/03/2021
 * authors Annie, Miguel, Vasily
 *
 * Within this class the user which by now will have chosen a drink,
 * the name of the drink will be display. A go-back button can be press
 * to try fit a match, also drink ingredients will be display giving
 * the option to add the chosen the drink to favorites or drink me button.
 */


public class DrinkDetail extends AppCompatActivity {

    // Variable declaration
    DatabaseAccess db;
    private TextView drink_name, show_ingredient;
    private ImageView showGlass;
    Button drinkMe;
    private static final String TAG = "misumisu";
    FloatingActionButton addToFavs;
    SharedPreferences tempStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_detail);
        tempStorage = getSharedPreferences(SignupActivity.TEMP_STORAGE, Activity.MODE_PRIVATE);

        DatabaseAccess drinksAccess = DatabaseAccess.getInstance(getApplicationContext());
        drinksAccess.open();

        db = new DatabaseAccess(this);

        //Instantiate variable
        drink_name = findViewById(R.id.drink_name);
        show_ingredient = findViewById(R.id.show_ingredient);
        showGlass = findViewById(R.id.img_drink);

        drinkMe = findViewById(R.id.add_me_fuel);
        addToFavs = findViewById(R.id.favBtn);

        //get Intent and show drink detail
        String drinkName = getIntent().getStringExtra(ChosenDrinkSecondActivity.NAME_KEY);
        drink_name.setText(drinkName);
        String details = getIntent().getStringExtra(ChosenDrinkSecondActivity.DETAIL_KEY);
        show_ingredient.setText(details);

    if(drinksAccess.checkFavs(drinkName)){
    addToFavs.setImageResource(R.drawable.ic_baseline_favorite_24);
    }
        addToFavs.setOnClickListener(v -> {
            if(drinksAccess.checkFavs(drinkName)){
                Toast.makeText(DrinkDetail.this, "Drink already in favorites", Toast.LENGTH_SHORT).show();
            }else {
                drinksAccess.setOrResetHeartDrink(1, drinkName);
                addToFavs.setImageResource(R.drawable.ic_baseline_favorite_24);
            }
        });

        // if/else statements to check for spirit names in the
        // database and assigns each with a drawable/image
        db.open();
        Resources glasses = getResources();
        if (db.getSpitOnly(drinkName).contains("Whiskey")) {
            Log.d("imageset", "SET");
            showGlass.setImageResource(R.drawable.whiskey_color);
        } else if (db.getSpitOnly(drinkName).contains("Rum")) {
            showGlass.setImageResource(R.drawable.mojito);
        } else if (db.getSpitOnly(drinkName).contains("Tequila")) {
            showGlass.setImageResource(R.drawable.rum_png_smallsize);
        } else if (db.getSpitOnly(drinkName).contains("Gin")) {
            showGlass.setImageResource(R.drawable.gin);
        } else if (db.getSpitOnly(drinkName).contains("Vodka")) {
            showGlass.setImageResource(R.drawable.vodka_png_smallsize);
        } else if (db.getSpitOnly(drinkName).contains("Sparkling wine")) {
            showGlass.setImageResource(R.drawable.pcosecco_png_smallsize);
        } else {
            showGlass.setImageResource(R.drawable.cocktail);
        }
        //Going back to the activity depending on if you are signed in or not
        drinkMe.setOnClickListener(v -> {
            Intent getToRecoms = new Intent(DrinkDetail.this, DrinkRecommendationPage.class);
            Intent getToMain = new Intent(DrinkDetail.this, MainActivity.class);
            if(tempStorage.getBoolean(SignupActivity.SIGNED, false)) {
                if (tempStorage.getInt(FuelBarSet.LIMIT_AMOUNT, 0) == 0) {
                    db.resetChosen();
                    startActivity(getToRecoms);
                } else {
                    db.setChosen(drinkName);
                    startActivity(getToRecoms);
                }
            }else {
                startActivity(getToMain);
            }

        });
    }
}
