package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Signup_ConfirmationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__confirmation_screen);

        //get Intent
        Intent intent = getIntent();
        //Display a welcome message to user
        TextView welcome_message = (TextView) findViewById(R.id.welcome_text);
        welcome_message.setText(R.string.welcome_message);
    }
}