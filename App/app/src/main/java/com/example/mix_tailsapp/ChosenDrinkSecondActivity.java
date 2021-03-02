package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

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
        drinkOfYourChoice = (TextView) findViewById(R.id.usersDrink);
        // When using the surprise me button
        if(getIntent().getStringExtra(QuestionSpinner.SURPRISE_KEY) != null){
            drinkOfYourChoice.setText(getIntent().getStringExtra(QuestionSpinner.SURPRISE_KEY));
        } else {
            // When using the lets drink button
            Log.d("Drink", getIntent().getStringExtra(QuestionSpinner.CHOICE_KEY));
            drinkOfYourChoice.setText(getIntent().getStringExtra(QuestionSpinner.CHOICE_KEY));
        }
    }
}