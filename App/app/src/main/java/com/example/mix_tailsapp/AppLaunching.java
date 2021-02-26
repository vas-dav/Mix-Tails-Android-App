package com.example.mix_tailsapp;
/**
 * Created by An Huynh on 15/02/2021
 * authors Annie, Miguel, Vasily
 * This class is used to display the logo and slogan with delay when the app is first launched
 */

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