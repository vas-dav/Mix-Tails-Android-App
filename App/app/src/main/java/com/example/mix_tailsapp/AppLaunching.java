package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class AppLaunching extends AppCompatActivity {

    private static final String SURPRISE_KEY = "KEWIOhguyfbvUWIGefyuowUILGYUOAWGYEURFQU3";

    @Override
    public void onCreate(Bundle savedInstance) {

        super.onCreate(savedInstance);
        setContentView(R.layout.activity_app_launching);
        // App launching page with delay
        new Handler().postDelayed(() -> {
            Intent launchApp = new Intent(AppLaunching.this, MainActivity.class);
            startActivity(launchApp);
        }, 2000);


    }


}