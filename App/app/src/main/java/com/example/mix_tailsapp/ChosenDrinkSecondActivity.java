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
 * After the user has decided to take our fun little quiz to select the perfect drink
 * or by going nomad with our randomizer, the app with me directed to a page where
 * cocktail name will be shown. Here the user will have the choice to see the
 * ingredients(DrinkDetails class) to choose to drink or save it to favorites,
 * also why not just go back to drink and search for another drink or why not go to
 * recommended drinks to let the app guide you depending on the quiz answers!
 *
 * @version 3: connecting buttons to their functionaries
 */

public class ChosenDrinkSecondActivity extends AppCompatActivity {

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
        drinkOfYourChoice = findViewById(R.id.usersDrink);
        goBack = findViewById(R.id.gobackBtn);
        ingredients = findViewById(R.id.ingredientBtn);

        //onClickListener for go back button
        goBack.setOnClickListener(view -> goBack.setOnClickListener(v -> {
            Intent backToHome = new Intent(ChosenDrinkSecondActivity.this, QuestionSpinner.class);
            startActivity(backToHome);
        }));

        String surprise = getIntent().getStringExtra(QuestionSpinner.SURPRISE_KEY);
        String choice = getIntent().getStringExtra(QuestionSpinner.CHOICE_KEY);
        String drinkIngredients = getIntent().getStringExtra(QuestionSpinner.INGS_KEY);

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

            goBack.setOnClickListener(view -> goBack.setOnClickListener(v -> {
                Intent backToHome = new Intent(ChosenDrinkSecondActivity.this, QuestionSpinner.class);
                startActivity(backToHome);
            }));
        }
    }

    /**
     * a method to show drink ingredients
     *
     * @param input input
     * @param i i
     */

    private void showIngs(String input, String i) {
        Intent DrinkDetails = new Intent(ChosenDrinkSecondActivity.this, DrinkDetail.class);
        DrinkDetails.putExtra(DETAIL_KEY, i);
        DrinkDetails.putExtra(NAME_KEY, input);
        startActivity(DrinkDetails);
    }
}


