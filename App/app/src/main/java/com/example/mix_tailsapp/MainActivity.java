package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaring variables
    SharedPreferences tempStorageGet, permStorageGet;
    TextView welcomeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //calling for both Storage on the AppLaunching Screen
        tempStorageGet = getSharedPreferences(SignupActivity.TEMP_STORAGE, Activity.MODE_PRIVATE);
        permStorageGet = getSharedPreferences(SignupActivity.PERM_STORAGE, Activity.MODE_PRIVATE);


        //Checking for userData in sharedPreferences and deciding which xml to use

        //if userData is not empty, show a welcoming message
        if (tempStorageGet.getBoolean(SignupActivity.SIGNED, false)) {
            setContentView(R.layout.activity_app_launching_logged_in);
            String name = permStorageGet.getString(SignupActivity.EXTRA_NAME, "User");
            welcomeText = (TextView) findViewById(R.id.welcomeBack);
            welcomeText.setText("Welcome back, " + name);

            //A function for deleting data from TempStorage sharedPreferences (logging out)
            Button logoutBtn = findViewById(R.id.logOut);
            logoutBtn.setOnClickListener(v -> {

                Intent logout = new Intent(this, AppLaunching.class);
                SharedPreferences.Editor deleter = tempStorageGet.edit();
                deleter.clear();
                if (deleter.commit()) {
                    startActivity(logout);
                }
            });

        }
        //if userData is empty, then show activity with signIN/signUP
        else {
            setContentView(R.layout.activity_main);
            //Create onClick method for sign up button to open the sign up form
            Button signupBtn = findViewById(R.id.signupBtn);
            signupBtn.setOnClickListener(v -> {

                //open activity
                Intent intent = new Intent(this, SignupActivity.class);
                startActivity(intent);

            });

            //Create onClick method for sign in button to open the sign in form
            Button signInBtn = findViewById(R.id.loginBtn);
            signInBtn.setOnClickListener(v -> {

                //open activity
                Intent signIn = new Intent(this, SignInActivity.class);
                startActivity(signIn);

            });



        }

    }


    //A function for "Let's Decide!" button to move you into QuestionSpinner
    public void decide(View view) {
        Intent questions = new Intent(MainActivity.this, QuestionSpinner.class);
        startActivity(questions);
    }
}