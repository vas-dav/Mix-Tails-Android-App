package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AppLaunching extends AppCompatActivity {
    private EditText name, email, password, comfirm_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_launching);

        //casting the edit text variables to their ids
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        comfirm_password = findViewById(R.id.comfirm_password);

        //Create onClick method for sign up button to open the sign up form
        Button signupBtn = findViewById(R.id.signupBtn);
        signupBtn.setOnClickListener(v -> {

            //open activity
            Intent intent = new Intent(this, SignupActivity.class);
            startActivity(intent);

        });
    }


    public void decide (View view){
        Intent questions = new Intent(AppLaunching.this, QuestionSpinner.class);
        startActivity(questions);
    }


}