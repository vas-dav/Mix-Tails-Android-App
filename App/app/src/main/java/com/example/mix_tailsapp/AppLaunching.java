package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AppLaunching extends AppCompatActivity {

    //Declaring variables
    SharedPreferences StorageGet;
    TextView welcomeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageGet = getSharedPreferences(SignupActivity.STORAGE, Activity.MODE_PRIVATE);

        //Checking for userData in sharedPreferences and deciding which xml to use

        //if userData is not empty, show a welcoming message
        if (StorageGet.getString(SignupActivity.EXTRA_NAME, null) != null) {
            setContentView(R.layout.activity_app_launching_logged_in);
            String name = StorageGet.getString(SignupActivity.EXTRA_NAME, "User");
            welcomeText = (TextView) findViewById(R.id.welcomeBack);
            welcomeText.setText("Welcome back,\n" + name);

            //A function for deleting data from sharedPreferences (logging out)
            Button logoutBtn = findViewById(R.id.logOut);
            logoutBtn.setOnClickListener(v -> {

                Intent logout = new Intent(this, MainActivity.class);
                SharedPreferences.Editor deleter = StorageGet.edit();
                deleter.clear();
                if (deleter.commit()) {
                    startActivity(logout);
                }
            });

        }
        //if userData is empty, then show activity with signIN/signUP
        else {
            setContentView(R.layout.activity_app_launching);
            //Create onClick method for sign up button to open the sign up form
            Button signupBtn = findViewById(R.id.signupBtn);
            signupBtn.setOnClickListener(v -> {

                //open activity
                Intent intent = new Intent(this, SignupActivity.class);
                startActivity(intent);

            });

            //Create onClick method for log in button to open the log in page
            Button loginBtn = findViewById(R.id.loginBtn);
            loginBtn.setOnClickListener(v -> {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            });
        }


    }


    //A function for "Let's Decide!" button to move you into QuestionSpinner
    public void decide(View view) {
        Intent questions = new Intent(AppLaunching.this, QuestionSpinner.class);
        startActivity(questions);
    }
}