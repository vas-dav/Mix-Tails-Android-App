package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class QuestionSpinner extends AppCompatActivity {

    //Declaring String arrays and Strings for Spinners for algorithm to use them
    String[] spirits = {"Choose-one", "Non-alcoholic", "Rum", "Vodka", "Gin", "Whiskey", "Tequila", "Sparkling wine"};
    String[] taste = {"Choose-one", "Sweet", "Sour","Bitter", "Bitter-Sweet", "Fresh", "Boozy"};
    String[] size = {"Choose-one", "S", "M", "L"};
    String[] strength = {"Choose-one", "Soft", "Light", "Strong"};
    String spiritsChoice, tasteChoice, sizeChoice, strengthChoice;

    //Keys for intending to move data from this activity to others
    protected static final String SURPRISE_KEY = "KEWIOhguyfbvUWIGefyuowUILGYUOAWGYEURFQU3";
    protected static final String CHOICE_KEY = "AFOIEHGUAHUwgirbUGIHuiwHI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_spinner);
        findViewById(R.id.surprise).setOnClickListener(onClickListener);
        findViewById(R.id.send).setOnClickListener(onClickListener);

        // All drop down sources(4) for questions connected to the arrays above ^^^
        Spinner mySpirits = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, spirits);
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpirits.setAdapter(myAdapter1);
        mySpirits.setOnItemSelectedListener(new spiritSpinnerClass());

        Spinner myTaste = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, taste);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myTaste.setAdapter(myAdapter2);
        myTaste.setOnItemSelectedListener(new tasteSpinnerClass());

        Spinner mySize = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, size);
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySize.setAdapter(myAdapter3);
        mySize.setOnItemSelectedListener(new sizeSpinnerClass());

        Spinner myStrength = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<String> myAdapter4 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, strength);
        myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myStrength.setAdapter(myAdapter4);
        myStrength.setOnItemSelectedListener(new strengthSpinnerClass());


    }

    // Classes of each adapter corresponding to all(4) drop down list items
    // with the option of returning null if "Choose-one" input is chosen
    class spiritSpinnerClass implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            spiritsChoice = spirits[position];

        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
    class tasteSpinnerClass implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            tasteChoice = taste[position];
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
    class sizeSpinnerClass implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            sizeChoice = size[position];
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
    class strengthSpinnerClass implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            strengthChoice = strength[position];
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    //A function for two separated buttons [Surprise Me!] & [Let's Drink!]
    private View.OnClickListener onClickListener = view -> {
        Intent chosenDrink = new Intent(QuestionSpinner.this, ChosenDrinkSecondActivity.class);
        DatabaseAccess drinksAccess = DatabaseAccess.getInstance(getApplicationContext());
        drinksAccess.open();
        //if/else statement for recognising which button is pressed
        if(view.getId() == R.id.surprise){
            //String i = drinksAccess
            //chosenDrink.putExtra(SURPRISE_KEY, i);
        } else {

            DatabaseAccess drinksAccess = DatabaseAccess.getInstance(getApplicationContext());
            drinksAccess.open();


            String total = drinksAccess.getDrink(spiritsChoice, tasteChoice, sizeChoice, strengthChoice);
            Log.d("Total", total);
            chosenDrink.putExtra(CHOICE_KEY, total);

            drinksAccess.close();
            if(total != null) {
                startActivity(chosenDrink);
            }else {
                Log.d("error here", "total is null");
            }
        }
        startActivity(chosenDrink);
    };
}

