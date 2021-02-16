package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ChosenDrinkSecondActivity extends AppCompatActivity {

    TextView drinkOfYourChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_drink__second);
        Drinks drinks = Drinks.getInstance();
        drinkOfYourChoice = (TextView) findViewById(R.id.usersDrink);
        if(getIntent().getStringExtra(QuestionSpinner.SURPRISE_KEY) != null){
            drinkOfYourChoice.setText(getIntent().getStringExtra(QuestionSpinner.SURPRISE_KEY));
        } else {
            Log.d("Drink", getIntent().getStringExtra(QuestionSpinner.CHOICE_KEY));
            drinkOfYourChoice.setText(getIntent().getStringExtra(QuestionSpinner.CHOICE_KEY));
        }
    }
}