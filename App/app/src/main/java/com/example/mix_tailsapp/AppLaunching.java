package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.mix_tailsapp.ui.login.LoginActivity;

public class AppLaunching extends AppCompatActivity {

    SharedPreferences StorageGet;
    TextView welcomeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StorageGet = getSharedPreferences(SignupActivity.STORAGE, Activity.MODE_PRIVATE);

        if(StorageGet.getString(SignupActivity.EXTRA_NAME, null) != null){
            setContentView(R.layout.activity_app_launching_logged_in);
            String name = StorageGet.getString(SignupActivity.EXTRA_NAME, "User");
            welcomeText = (TextView) findViewById(R.id.welcomeBack);
            welcomeText.setText("Welcome back,\n" + name);
            Button logoutBtn = findViewById(R.id.logOut);
            logoutBtn.setOnClickListener(v -> {

                //open activity
                Intent logout = new Intent(this, MainActivity.class);
                SharedPreferences.Editor deleter = StorageGet.edit();
                deleter.clear();
                if(deleter.commit()) {
                    startActivity(logout);
                }
            });

        }else{
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


    public void decide(View view) {
        Intent questions = new Intent(AppLaunching.this, QuestionSpinner.class);
        startActivity(questions);
    }


}