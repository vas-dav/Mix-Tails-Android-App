package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String SURPRISE_KEY = "KEWIOhguyfbvUWIGefyuowUILGYUOAWGYEURFQU3";

    @Override
    public void onCreate(Bundle savedInstance) {

        // App launching page with delay
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(() -> {
            Intent launchApp = new Intent(MainActivity.this, AppLaunching.class);
            startActivity(launchApp);
        }, 2000);


    }


}