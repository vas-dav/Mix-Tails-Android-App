
package com.example.mix_tailsapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by Annie on 02/03/2021
 * authors Annie, Miguel, Vasily
 * This is the activity for user adding a new drink
 * @version 1: creating java class, declare and instantiate variables (Annie)
 * @version 2: writing onClickListener method (Annie)
 * @version 3: adding drink database to the class by calling (Vasily)
 * @version 4: fixing the sendDrink button function (Miguel)
 */

public class AddingDrink extends AppCompatActivity {

    DatabaseAccess db;
    public EditText editName, editSpirit, editTaste, editSize, editStrength, editIngredients;
    private Button sendDrink;
    private ImageButton goBack;

    /**
     * an onClickListener function to decide what happen when the button binding with its id is clicked
     */


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == sendDrink) {
                if (editName.getText().toString().isEmpty()|| editSpirit.getText().toString().isEmpty()||
                        editTaste.getText().toString().isEmpty()|| editSize.getText().toString().isEmpty()||
                        editStrength.getText().toString().isEmpty()|| editIngredients.getText().toString().isEmpty())
                {
                    Toast.makeText(AddingDrink.this, "Field cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    new Handler().postDelayed(() -> {
                        setContentView(R.layout.activity_add_drink_confirmation);
                        AddData();
                    }, 2000);
                }
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

        db = new DatabaseAccess(this);


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


    }
    // Function for adding new drinks to (Drinks.db)
    public void AddData() {

        db.open();
        Intent addDrink = new Intent(AddingDrink.this, DrinkRecommendationPage.class);
        if (db.insertDrink(editName.getText().toString(),
                editSpirit.getText().toString(),
                editTaste.getText().toString(),
                editSize.getText().toString(),
                editStrength.getText().toString(),
                editIngredients.getText().toString()));
         {
            db.close();
            startActivity(addDrink);
        }
    }
}
