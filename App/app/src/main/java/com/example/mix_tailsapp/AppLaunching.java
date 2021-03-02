package com.example.mix_tailsapp;
/**
 * Created by An Huynh on 15/02/2021
 * authors Annie, Miguel, Vasily
 * This class is used to display the logo and slogan with delay when the app is first launched and decide which activity to open firstly
 */

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class AppLaunching extends AppCompatActivity {
    SharedPreferences tempStorageGet;
    private static final String SURPRISE_KEY = "KEWIOhguyfbvUWIGefyuowUILGYUOAWGYEURFQU3";

    @Override
    public void onCreate(Bundle savedInstance) {


        super.onCreate(savedInstance);
        setContentView(R.layout.activity_app_launching);
        tempStorageGet = getSharedPreferences(SignupActivity.TEMP_STORAGE, Activity.MODE_PRIVATE);
        // App launching page with delay
        new Handler().postDelayed(() -> {
            //Deciding which activity to open depending on the signed boolean
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