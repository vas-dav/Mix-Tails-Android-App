package com.example.mix_tailsapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by An Huynh on 15/02/2021
 * authors Annie, Miguel, Vasily
 *
 * This activity is meant to display the logo and slogan of the app mesmerizing
 * the user with out amazing design and colors. After launch the user will directed
 * to a small quiz to figure out the perfect drink or randomize one for fun!
 *
 * version 1: Adding intent
 * version 2: using SharedPreference to open activity based on the signed boolean
 */

import androidx.appcompat.app.AppCompatActivity;

public class AppLaunching extends AppCompatActivity {
    private SharedPreferences tempStorageGet;
    private static final String SURPRISE_KEY = "KEWIOhguyfbvUWIGefyuowUILGYUOAWGYEURFQU3";

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_app_launching);
        tempStorageGet = getSharedPreferences(SignupActivity.TEMP_STORAGE, Activity.MODE_PRIVATE);
        /**
         * App launching page with delay
         * Deciding which activity to open depending on the signed boolean
         */
        new Handler().postDelayed(() -> {
            if(tempStorageGet.getBoolean(SignInActivity.SIGNED, false)){
                Intent signedLaunch = new Intent(AppLaunching.this, AppWelcomeScreen.class);
                startActivity(signedLaunch);
            } else{
                Intent launchApp = new Intent(AppLaunching.this, MainActivity.class);
                startActivity(launchApp);
            }
        }, 2000);
    }
}