package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.example.mix_tailsapp.EXTRA_NAME";
    public static final String EXTRA_EMAIL = "com.example.mix_tailsapp.EXTRA_EMAIL";
    public static final String EXTRA_PASS = "com.example.mix_tailsapp.EXTRA_PASS";
    public static final String EXTRA_CONFIRMPASS = "com.example.mix_tailsapp.EXTRA_CONFIRMPASS";

    private EditText name, email, password, comfirm_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Intent intent = getIntent();
    }
}