package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String SURPRISE_KEY = "KEWIOhguyfbvUWIGefyuowUILGYUOAWGYEURFQU3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Spinner mySpirits = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spirits));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpirits.setAdapter(myAdapter1);

        Spinner myTaste = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.taste));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myTaste.setAdapter(myAdapter2);

        Spinner mySize = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.size));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySize.setAdapter(myAdapter3);

        Spinner myStrength = (Spinner) findViewById(R.id.spinner4);

        ArrayAdapter<String> myAdapter4 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.strength));
        myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myStrength.setAdapter(myAdapter4);


/*
        AdapterView.OnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(Adapter<?> adapterView, View DrinksData, int i, long ) {
                Intent nextActivity = new Intent(MainActivity.this, DrinksData.class);
                nextActivity.putExtra(ListOfDrinks, i);
                startActivity(nextActivity);
            }
        }); */

    }
    //a function for generating a random drink
    public void randomize(View view) {
        Drinks drinks = Drinks.getInstance();
        String i = drinks.surprise();
        Intent randDrink = new Intent(MainActivity.this, ChosenDrink_SecondActivity.class);
        randDrink.putExtra(SURPRISE_KEY, i);

    }

}