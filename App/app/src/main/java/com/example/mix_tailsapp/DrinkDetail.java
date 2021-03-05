package com.example.mix_tailsapp;
/**
 * Created by Annie on 01/03/2021
 * authors Annie, Miguel, Vasily
 * This class is used to show drink ingredients
 */

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DrinkDetail extends AppCompatActivity {
    // Variable declaration
    private TextView drink_name, show_ingredient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_detail);

        //Instantiate variable
        drink_name = findViewById(R.id.drink_name);
        show_ingredient = findViewById(R.id.show_ingredient);

        //get Intent and show drink detail
        String drinkName = getIntent().getStringExtra(ChosenDrinkSecondActivity.NAME_KEY);
        drink_name.setText(drinkName);
        String details = getIntent().getStringExtra(ChosenDrinkSecondActivity.DETAIL_KEY);
        show_ingredient.setText(details);



    }
}