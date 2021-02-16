package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignupConfirmationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__confirmation_screen);

        //A function for returning back on the mainMenu
      Button returnButton = (Button)findViewById(R.id.endSubscription);
      returnButton.setOnClickListener(v -> {
          Intent goBack = new Intent(SignupConfirmationScreen.this, AppLaunching.class);
          startActivity(goBack);
      });

    }
}