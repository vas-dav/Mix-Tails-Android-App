package com.example.mix_tailsapp;
/**
 * Created by Annie (An Huynh) on 24/02/2021
 * authors: Annie, Miguel, Vasily
 * This class is created for the app welcome activity and decide what will happen when the three
 * buttons in this activity are clicked
 */

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AppWelcomeScreen extends AppCompatActivity {
    //Declare variables
    private Button decideBtn, recommendBtn, drivingEstimation, favoriteBtn;
    private ImageButton logOut;
    private SharedPreferences tempStoragePut, permStorageGet;
    TextView welcomeText;
    //create an onClick listener when the buttons are clicked
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == decideBtn) {
                Intent chooseDrink = new Intent(AppWelcomeScreen.this, QuestionSpinner.class);
                startActivity(chooseDrink);
            }
            if (v == recommendBtn) {
                Intent recommend = new Intent(AppWelcomeScreen.this, DrinkRecommendationPage.class);
                startActivity(recommend);
            }
            if (v == drivingEstimation) {
                Intent driving = new Intent(AppWelcomeScreen.this, DrivingProgress.class);
                startActivity(driving);
            }
            if (v == logOut) {
                //Deleting the TEMPMEM signed boolean
                tempStoragePut = getSharedPreferences(SignupActivity.TEMP_STORAGE, Activity.MODE_PRIVATE);
                Intent signOut = new Intent(AppWelcomeScreen.this,
                        AppLaunching.class);
                SharedPreferences.Editor deleter = tempStoragePut.edit();
                deleter.clear();
                if (deleter.commit()) {
                    startActivity(signOut);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_welcome_screen);
        permStorageGet = getSharedPreferences(SignupActivity.PERM_STORAGE, Activity.MODE_PRIVATE);
        String name = permStorageGet.getString(SignupActivity.EXTRA_NAME, "User");
        welcomeText = (TextView) findViewById(R.id.welcomeBack);
        welcomeText.setText("Welcome back " + name);
        // Link the button variables with their ids
        decideBtn = findViewById(R.id.decideBtn);
        recommendBtn = findViewById(R.id.recommendBtn);
        drivingEstimation = findViewById(R.id.drivingBtn);
        favoriteBtn = findViewById(R.id.myfavoriteBtn);
        logOut = findViewById(R.id.logOut);

        //calling the onClick method
        decideBtn.setOnClickListener(clickListener);
        recommendBtn.setOnClickListener(clickListener);
        drivingEstimation.setOnClickListener(clickListener);
        favoriteBtn.setOnClickListener(clickListener);
        logOut.setOnClickListener(clickListener);





    }
}