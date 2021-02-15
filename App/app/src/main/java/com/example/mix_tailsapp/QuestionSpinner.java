package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;


public class QuestionSpinner extends AppCompatActivity {

    String[] spirits = {"Choose-one", "Non-alcoholic", "Rum", "Vodka", "Gin", "Whiskey", "Bourbon", "Prosecco"};
    String[] taste = {"Choose-one", "Salty", "Sweet", "Sour", "Bitter", "Bitter-Sweet", "Fresh", "Boozy"};
    String[] size = {"Choose-one", "S", "M", "L"};
    String[] strength = {"Choose-one", "Soft", "Mild", "Strong"};
    String spiritsChoice, tasteChoice, sizeChoice, strengthChoice;


    private static final String SURPRISE_KEY = "KEWIOhguyfbvUWIGefyuowUILGYUOAWGYEURFQU3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_spinner);

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



    public void send(View view) {
        Drinks drinks = Drinks.getInstance();
        Intent chosenDrink = new Intent(QuestionSpinner.this, ChosenDrink_SecondActivity.class);
        String total = drinks.compareDrinks(spiritsChoice, sizeChoice, tasteChoice, strengthChoice);
        chosenDrink.putExtra("drinker", total);

        startActivity(chosenDrink);
    }


    //a function for generating a random drink
    public void randomize(View view) {
        Drinks drinks = Drinks.getInstance();
        String i = drinks.surprise();
        Intent randDrink = new Intent(QuestionSpinner.this, ChosenDrink_SecondActivity.class);
        randDrink.putExtra(SURPRISE_KEY, i);
        startActivity(randDrink);
    }

}

