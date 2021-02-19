package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SignupConfirmationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__confirmation_screen);

        //A function for returning back on the mainMenu
      Button returnButton = (Button)findViewById(R.id.exploreBtn);
      returnButton.setOnClickListener(v -> {
          Intent goToWelcomePage = new Intent(SignupConfirmationScreen.this, DrinkRecommendationPage.class);
          startActivity(goToWelcomePage);
      });

    }
}