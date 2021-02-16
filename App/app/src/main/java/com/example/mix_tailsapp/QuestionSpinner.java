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
    String[] spirits = {"Choose-one", "Non-alcoholic", "Rum", "Vodka", "Gin", "Whiskey/Bourbon", "Prosecco"};
    String[] taste = {"Choose-one", "Sweet", "Sour", "Salty", "Bitter", "Bitter-Sweet", "Fresh", "Boozy"};
    String[] size = {"Choose-one", "S", "M", "L"};
    String[] strength = {"Choose-one", "Soft", "Mild", "Strong"};
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

    class spiritSpinnerClass implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            Toast.makeText(v.getContext(), spirits[position], Toast.LENGTH_SHORT).show();
            spiritsChoice = spirits[position];
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
    class tasteSpinnerClass implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            Toast.makeText(v.getContext(), taste[position], Toast.LENGTH_SHORT).show();
            tasteChoice = taste[position];
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
    class sizeSpinnerClass implements AdapterView.OnItemSelectedListener {
       public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            Toast.makeText(v.getContext(), size[position], Toast.LENGTH_SHORT).show();
            sizeChoice = size[position];
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
    class strengthSpinnerClass implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            Toast.makeText(v.getContext(), strength[position], Toast.LENGTH_SHORT).show();
            strengthChoice = strength[position];
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    //A function for two separated buttons [Surprise Me!] & [Let's Drink!]
    private View.OnClickListener onClickListener = view -> {
        Intent chosenDrink = new Intent(QuestionSpinner.this, ChosenDrinkSecondActivity.class);
        Drinks drinks = Drinks.getInstance();
        //if/else statement for recognising which button is pressed
        if(view.getId() == R.id.surprise){
            String i = drinks.surprise();
            chosenDrink.putExtra(SURPRISE_KEY, i);
        } else {
            String total = drinks.compareDrinks(spiritsChoice, sizeChoice, tasteChoice, strengthChoice);
            Log.d("Total", total);
            chosenDrink.putExtra(CHOICE_KEY, total);
        }
        startActivity(chosenDrink);
    };
}

