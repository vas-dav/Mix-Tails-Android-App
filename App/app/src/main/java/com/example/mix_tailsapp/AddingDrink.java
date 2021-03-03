package com.example.mix_tailsapp;
/**
 * Created by Annie on 02/03/2021
 * authors Annie, Miguel, Vasily
 * This is the activity for user adding a new drink
 */

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

public class AddingDrink extends AppCompatActivity {

    DatabaseAccess plusDB;
    public EditText editName, editSpirit, editTaste, editSize, editStrength, editIngredients ;
    private Button sendDrink; // ALSO ADD GO-BACK BUTTON please :)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_drink);
        DatabaseAccess drinksAccess = DatabaseAccess.getInstance(getApplicationContext());
        drinksAccess.open();

        plusDB = new DatabaseAccess(this);

        editName = (EditText) findViewById(R.id.editName);
        editSpirit = (EditText) findViewById(R.id.editSpirit);
        editTaste = (EditText) findViewById(R.id.editTaste);
        editSize = (EditText) findViewById(R.id.editSize);
        editStrength = (EditText) findViewById(R.id.editStrength);
        editIngredients = (EditText) findViewById(R.id.editIngredients);
        sendDrink = (Button) findViewById(R.id.add);
        AddData();
        drinksAccess.close();

        //Button add drink onClickListener
        sendDrink = findViewById(R.id.sendDrink);
    }
            public void AddData() {
            sendDrink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Handler().postDelayed(() -> {
                        setContentView(R.layout.activity_add_drink_confirmation);
                        Intent launchApp = new Intent(AddingDrink.this, DrinkRecommendationPage.class);
                        startActivity(launchApp);
                }, 2000);
            }
        });


    }
}