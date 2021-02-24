package com.example.mix_tailsapp;
/**
 * Created by Annie (An Huynh) on 24/02/2021
 * authors: Annie, Miguel, Vasily
 * This class is created for the app welcome activity and decide what will happen when the three
 * buttons in this activity are clicked
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppWelcomeScreen extends AppCompatActivity {
    //Declare variables
    private Button recommendBtn, drivingEstimation, favoriteBtn;

    //create an onClick listener when the buttons are clicked
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == recommendBtn){
                Intent recommend = new Intent(AppWelcomeScreen.this, DrinkRecommendationPage.class);
                startActivity(recommend);
            }
            if (v == drivingEstimation) {
                Intent driving = new Intent(AppWelcomeScreen.this, DrivingProgress.class);
                startActivity(driving);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_welcome_screen);
        // Link the button variables with their ids
        recommendBtn = findViewById(R.id.recommendBtn);
        drivingEstimation = findViewById(R.id.drivingBtn);
        favoriteBtn = findViewById(R.id.myfavoriteBtn);

        //calling the onClick method
        recommendBtn.setOnClickListener(clickListener);
        drivingEstimation.setOnClickListener(clickListener);
        favoriteBtn.setOnClickListener(clickListener);

    }
}
