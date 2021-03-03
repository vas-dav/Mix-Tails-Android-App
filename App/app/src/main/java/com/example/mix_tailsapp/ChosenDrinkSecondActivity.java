package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;



public class ChosenDrinkSecondActivity extends AppCompatActivity {

    TextView drinkOfYourChoice;

    // Intents for Surprise me button and lets drink button generator
    // in the questionnaire after or when logged in.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surprise_drink);
        SharedPreferences tempStorageGet = getSharedPreferences(SignupActivity.TEMP_STORAGE, Activity.MODE_PRIVATE);
        drinkOfYourChoice = (TextView) findViewById(R.id.usersDrink);

        //--------------------------------------------
        //---> IMPORTANT! DO NOT DO THE FUNCTIONALITY
        //---> OF BUTTONS. WE HAVEN'T MADE A SPECIAL
        //---> MEMORY FOR STORING USER'S DRINKS
        //--------------------------------------------

        //Checking if you are signed in: (this [getBoolean] should return true if you are signed),
        //So, if signed returns true -> "Save Drink and Go back", otherwise just "Go back"
        //The "Show ingredients" Will appear in both cases

        //-----------------------------------------
        //---> "Show Ingredients" should go here
        //-----------------------------------------

            // When using the surprise me button
        if (getIntent().getStringExtra(QuestionSpinner.SURPRISE_KEY) != null) {
            drinkOfYourChoice.setText(getIntent().getStringExtra(QuestionSpinner.SURPRISE_KEY));
        } else {
            // When using the lets drink button
            drinkOfYourChoice.setText(getIntent().getStringExtra(QuestionSpinner.CHOICE_KEY));
        }
        if (tempStorageGet.getBoolean(SignupActivity.SIGNED, false)) {

            //--------------------------------------------
            //---> "Save Drink And Go Back" should go Here
            //--------------------------------------------
        } else {
            //--------------------------------------------
            //---> "Go Back" should go Here
            //--------------------------------------------
        }
    }
}