package com.example.mix_tailsapp;
/**
 * Created by Annie on 24/02/2021
 * authors: Annie, Vasily, Miguel
 * This activity is to determine the time estimated until the user is ready to drive after consuming
 * alcoholic cocktail drink
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class DrivingProgress extends AppCompatActivity {
    // variables declaration
    private Button goBackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving_progress);

        //Btn clicked and go back to app welcome activity
        goBackBtn = findViewById(R.id.gobackBtn);
        goBackBtn.setOnClickListener(v -> {
            Intent backToHomePage = new Intent(DrivingProgress.this, AppWelcomeScreen.class);
            startActivity(backToHomePage);
        });

    }
}