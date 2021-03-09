package com.example.mix_tailsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

/**
 * authors: Vasily, Miguel, Annie
 *
 * This activity is one of the first interactions with user
 * to decide if the user is already signed in or needs to sign up.
 *
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         *  Create onClick method for sign up button to open the sign up form
         */

        Button signupBtn = findViewById(R.id.signupBtn);
        signupBtn.setOnClickListener(v -> {

            //open activity
            Intent intent = new Intent(this, SignupActivity.class);
            startActivity(intent);

        });

        /**
         * Create onClick method for sign in button to open the sign in form
         */

        Button signInBtn = findViewById(R.id.loginBtn);
        signInBtn.setOnClickListener(v -> {

            //open activity
            Intent signIn = new Intent(this, SignInActivity.class);
            startActivity(signIn);

        });
    }

    /**
     * A function for "Let's Decide!" button to move you into QuestionSpinner
     */

    public void decide(View view) {
        Intent questions = new Intent(MainActivity.this, QuestionSpinner.class);
        startActivity(questions);
    }
}