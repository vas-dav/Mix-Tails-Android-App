package com.example.mix_tailsapp;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
/**
 * Created by Annie on 02/03/2021
 * authors Annie, Miguel, Vasily
 * This is the activity for user adding a new drink
 * version 1: creating java class, declare and instantiate variables
 * version 2: writing onClickListener method
 * version 3: adding drink database to the class by calling
 */
public class AddingDrink extends AppCompatActivity {

    DatabaseAccess plusDB;
    public EditText editName, editSpirit, editTaste, editSize, editStrength, editIngredients ;
    private Button sendDrink;
    private ImageButton goBack;


    /**
     * an onClickListener function to decide what happen when the button binding with its id is clicked
     */

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == sendDrink) {
                new Handler().postDelayed(() -> {
                    setContentView(R.layout.activity_add_drink_confirmation);
                    Intent launchApp = new Intent(AddingDrink.this, DrinkRecommendationPage.class);
                    startActivity(launchApp);
                }, 2000);
            }
            if (v == goBack) {
                Intent back = new Intent(AddingDrink.this, DrinkRecommendationPage.class);
                startActivity(back);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_drink);
        DatabaseAccess drinksAccess = DatabaseAccess.getInstance(getApplicationContext());
        drinksAccess.open();

        plusDB = new DatabaseAccess(this);

        //binding variables with ids
        editName = (EditText) findViewById(R.id.editName);
        editSpirit = (EditText) findViewById(R.id.editSpirit);
        editTaste = (EditText) findViewById(R.id.editTaste);
        editSize = (EditText) findViewById(R.id.editSize);
        editStrength = (EditText) findViewById(R.id.editStrength);
        editIngredients = (EditText) findViewById(R.id.editIngredients);


        //Button add drink onClickListener
        sendDrink = (Button) findViewById(R.id.sendDrink);
        goBack = (ImageButton) findViewById(R.id.gobackBtn);
        goBack.setOnClickListener(clickListener);
        sendDrink.setOnClickListener(clickListener);

        drinksAccess.close();
    }

}