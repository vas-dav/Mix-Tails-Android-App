package com.example.mix_tailsapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * authors: Vasily, Miguel, Annie
 * An activity for choosing drinks from user's choice of preferred ingredients or surprise drink
 * @version 1: instantiate variables and get sharePreferences
 * @version 2: adding buttons for getting ingredients, save drinks and going back
 * @version 3: connecting buttons to their functionalities
 */


public class ChosenDrinkSecondActivity extends AppCompatActivity {

    String[] imgSpit = {"Choose-one", "Non-alcoholic", "Rum", "Vodka", "Gin", "Whiskey", "Tequila", "Sparkling wine"};

    TextView drinkOfYourChoice;
    private ImageButton goBack;
    private Button ingredients;
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


        String surprise = getIntent().getStringExtra(QuestionSpinner.SURPRISE_KEY);
        String choice = getIntent().getStringExtra(QuestionSpinner.CHOICE_KEY);
        String drinkIngredients = getIntent().getStringExtra(QuestionSpinner.INGS_KEY);
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
            ingredients.setOnClickListener(v -> showIngs(surprise, drinkIngredients));
        } else {
            // When using the lets drink button
            drinkOfYourChoice.setText(choice);
            ingredients.setOnClickListener(v -> showIngs(choice, drinkIngredients));
        }
        if (tempStorageGet.getBoolean(SignupActivity.SIGNED, false)) {


        } else {

            goBack.setOnClickListener(v -> {
                Intent backToHome = new Intent(ChosenDrinkSecondActivity.this, AppWelcomeScreen.class);
                startActivity(backToHome);
            });


        }
    }

    /**
     * a method to show drink ingredients
     * @param input
     * @param i
     */
    private void showIngs(String input, String i) {
        Intent DrinkDetails = new Intent(ChosenDrinkSecondActivity.this, DrinkDetail.class);
        DrinkDetails.putExtra(DETAIL_KEY, i);
        DrinkDetails.putExtra(NAME_KEY, input);
        startActivity(DrinkDetails);

    }
   
    }


}