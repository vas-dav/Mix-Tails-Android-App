package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * authors: Vasily, Miguel, Annie
 * A class for choosing drinks from user's choice of preferred ingredients or surprise drink
 * version 1: instantiate variables and get sharePreferences
 * version 2: adding buttons for getting ingredients, save drinks and going back
 */


public class ChosenDrinkSecondActivity extends AppCompatActivity {

    TextView drinkOfYourChoice;
    private ImageButton goBack;
    private Button ingredients, saveDrink;
    DatabaseAccess drinksAccessIngs = DatabaseAccess.getInstance(getApplicationContext());
    Intent DrinkDetails = new Intent(ChosenDrinkSecondActivity.this, DrinkDetail.class);
    protected static final String DETAIL_KEY = "DIDYOUKNOWTHAT_EINSTEIN_IS_SUPERIOR_THAN_HAWKING";
    protected static final String NAME_KEY = "TOM_CRUISE_HAS_SUPERPOWERS_SUPERIOR_THAN_SUPERMAN";

    /**
     * Intents for Surprise me button and lets drink button generator
     * in the questionnaire after or when logged in.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surprise_drink);
        SharedPreferences tempStorageGet = getSharedPreferences(SignupActivity.TEMP_STORAGE, Activity.MODE_PRIVATE);

        //Initiate variables
        drinkOfYourChoice = (TextView) findViewById(R.id.usersDrink);
        goBack = findViewById(R.id.gobackBtn);
        ingredients = findViewById(R.id.ingredientBtn);
        saveDrink = findViewById(R.id.saveDrinkBtn);

        String surprise = getIntent().getStringExtra(QuestionSpinner.SURPRISE_KEY);
        String choice = getIntent().getStringExtra(QuestionSpinner.CHOICE_KEY);

        //--------------------------------------------
        //---> IMPORTANT! DO NOT DO THE FUNCTIONALITY
        //---> OF BUTTONS. WE HAVEN'T MADE A SPECIAL
        //---> MEMORY FOR STORING USER'S DRINKS
        //--------------------------------------------

        //Checking if you are signed in: (this [getBoolean] should return true if you are signed),
        //So, if signed returns true -> "Save Drink and Go back", otherwise just "Go back"
        //The "Show ingredients" Will appear in both cases



            // When using the surprise me button
        if (surprise != null) {
            drinkOfYourChoice.setText(surprise);
            ingredients.setOnClickListener(v -> showIngs(surprise));
        } else {
            // When using the lets drink button
            drinkOfYourChoice.setText(choice);
            ingredients.setOnClickListener(v -> showIngs(choice));
        }
        if (tempStorageGet.getBoolean(SignupActivity.SIGNED, false)) {



            saveDrink.setOnClickListener(v -> {

                new Handler().postDelayed(() -> {
                    setContentView(R.layout.activity_add_drink_confirmation);
                    Intent saveAndBack = new Intent(ChosenDrinkSecondActivity.this, AppWelcomeScreen.class);
                    startActivity(saveAndBack);
                }, 2000);



            });

                 
        } else {

            goBack.setOnClickListener(v -> {
                Intent backToHome = new Intent(ChosenDrinkSecondActivity.this, AppWelcomeScreen.class);
                startActivity(backToHome);
            });


        }
    }

    private void showIngs(String input) {
        String ings = drinksAccessIngs.getDrinkIngs2(input);
        DrinkDetails.putExtra(DETAIL_KEY, ings);
        DrinkDetails.putExtra(NAME_KEY, input);
        startActivity(DrinkDetails);

    }


}