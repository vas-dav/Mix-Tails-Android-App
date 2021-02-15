package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class QuestionSpinner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_spinner);

        Spinner mySpirits = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(QuestionSpinner.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.spirits));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpirits.setAdapter(myAdapter1);

        Spinner myTaste = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(QuestionSpinner.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.taste));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myTaste.setAdapter(myAdapter2);

        Spinner mySize = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(QuestionSpinner.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.size));
        myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySize.setAdapter(myAdapter3);

        Spinner myStrength = (Spinner) findViewById(R.id.spinner4);

        ArrayAdapter<String> myAdapter4 = new ArrayAdapter<String>(QuestionSpinner.this,
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
    }
}