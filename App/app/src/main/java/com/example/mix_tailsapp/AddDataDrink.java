package com.example.mix_tailsapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.logging.Handler;

public class AddDataDrink extends AppCompatActivity {

    SQLiteDatabase db;
    public EditText editName, editSpirit, editTaste, editSize, editStrength, editIngredients;
    private Button sendDrink;
    private ImageButton goBack;


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == sendDrink) {
                new Handler().postDelayed(() -> {
                    setContentView(R.layout.activity_add_drink_confirmation);
                    Intent launchApp = new Intent(AddDataDrink.this, DrinkRecommendationPage.class);
                    startActivity(launchApp);
                }, 2000);
            }
            if (v == goBack) {
                Intent back = new Intent(AddDataDrink.this, DrinkRecommendationPage.class);
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


        EditText editName = (EditText) findViewById(R.id.editName);
        EditText editSpirit = (EditText) findViewById(R.id.editSpirit);
        EditText editTaste = (EditText) findViewById(R.id.editTaste);
        EditText editSize = (EditText) findViewById(R.id.editSize);
        EditText editStrength = (EditText) findViewById(R.id.editStrength);
        EditText editIngredients = (EditText) findViewById(R.id.editIngredients);

        String nameAdd = editName.getText().toString();
        String spiritAdd = editSpirit.getText().toString();
        String tasteAdd = editTaste.getText().toString();
        String sizeAdd = editSize.getText().toString();
        String strengthAdd = editStrength.getText().toString();
        String ingredientsAdd = editIngredients.getText().toString();

        DatabaseAccess nc = new DatabaseAccess();
        nc.setName(nameAdd);
        nc.setName(spiritAdd);
        nc.setName(tasteAdd);
        nc.setName(sizeAdd);
        nc.setName(strengthAdd);
        nc.setName(ingredientsAdd);

        db.insertCockctail(nc);
        Toast temp = Toast.makeText(AddDataDrink.this, "Drinks added", Toast.LENGTH_SHORT);
        temp.show();

        Intent i = new Intent(AddDataDrink.this, DatabaseAccess.class);
        startActivity();



        //Button add drink onClickListener
        sendDrink = (Button) findViewById(R.id.sendDrink);
        goBack = (ImageButton) findViewById(R.id.gobackBtn);
        goBack.setOnClickListener(clickListener);
        sendDrink.setOnClickListener(v -> AddData());


    }
}
