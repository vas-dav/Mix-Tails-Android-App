package com.example.mix_tailsapp.UserActivity;
/**
 * Created by An Huynh on 18/02/2021
 * authors Annie
 * This activity is used to display a message to user to confirm that the sign up activity has been
 * successfully completed and return to the main menu automatically
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mix_tailsapp.HomePage;
import com.example.mix_tailsapp.R;

public class SignupConfirmationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__confirmation_screen);

        /**
         * A function for returning back on the mainMenu
         */

        new Handler().postDelayed(() -> {
            Intent launchApp = new Intent(SignupConfirmationScreen.this, HomePage.class);
            startActivity(launchApp);
        }, 2000);
    }
}