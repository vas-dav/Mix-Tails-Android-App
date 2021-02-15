package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ChosenDrink_SecondActivity extends AppCompatActivity {

    TextView drinkOfYourChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_drink__second);
        Bundle randDrink = getIntent().getExtras();
        String randomDrink = randDrink.getString("KEWIOhguyfbvUWIGefyuowUILGYUOAWGYEURFQU3");

        drinkOfYourChoice = (TextView) findViewById(R.id.usersDrink);
        drinkOfYourChoice.setText(randomDrink);

    }
}