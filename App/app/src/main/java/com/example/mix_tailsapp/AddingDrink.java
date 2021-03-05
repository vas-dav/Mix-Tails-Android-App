package com.example.mix_tailsapp;
/**
 * Created by Annie on 02/03/2021
 * authors Annie, Miguel, Vasily
 * This is the activity for user adding a new drink
 */

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class AddingDrink extends AppCompatActivity {

    DatabaseAccess plusDB;
    public EditText editName, editSpirit, editTaste, editSize, editStrength, editIngredients;
    private Button sendDrink;
    private ImageButton goBack;

    //clickListener
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
        sendDrink.setOnClickListener(v -> AddData());


    }
    // Function for adding new drinks to (Drinks.db)
    public void AddData() {

        plusDB.open();
        Intent addDrink = new Intent(AddingDrink.this, DrinkRecommendationPage.class);
        if (plusDB.insertDrink(editName.getText().toString(),
                editSpirit.getText().toString(),
                editTaste.getText().toString(),
                editSize.getText().toString(),
                editStrength.getText().toString(),
                editIngredients.getText().toString()
        )) {
            plusDB.close();
            startActivity(addDrink);
        }
    }
}
