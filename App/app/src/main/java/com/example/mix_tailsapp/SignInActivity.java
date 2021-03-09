package com.example.mix_tailsapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/**
 * authors: Vasily
 * an activity to decide what happen in the log in action
 */
public class SignInActivity extends AppCompatActivity {

    protected static final String SIGNED = "NEISRHUIGBHJSjioHUIRBRBAENUFUIS";
    SharedPreferences permStorageGet, tempStoragePut;
    Hasher passDeCoder = new Hasher();

    //Declaring variables
    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        Button signInBtnConfirm = findViewById(R.id.loginConfirm);
        signInBtnConfirm.setOnClickListener(v -> loginSubmit());



    }

    /**
     * submit the logIn form method
     */
    public void loginSubmit(){
        Log.d("LogIn", "Clicked");
        Intent loginSuccess = new Intent(SignInActivity.this, HomePage.class);
        /*
          Retrieving data from PERM and putting data on TEMP
         */
        permStorageGet = getSharedPreferences(SignupActivity.PERM_STORAGE, Activity.MODE_PRIVATE);
        tempStoragePut = getSharedPreferences(SignupActivity.TEMP_STORAGE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor tempEditor =  tempStoragePut.edit();
        if(permStorageGet.getString(SignupActivity.EXTRA_EMAIL, "null").equals(email.getText().toString())){
            //email is correct, now checking the password
            if(permStorageGet.getString(SignupActivity.EXTRA_PASS, "null").equals(passDeCoder.CrToBiWL(passDeCoder.hLtoS(passDeCoder.hPSCD(password.getText().toString()))))){
                tempEditor.putBoolean(SIGNED, true);
                if(tempEditor.commit()){
                    startActivity(loginSuccess);
                }
            }else{
                Log.d("PASS_SP", permStorageGet.getString(SignupActivity.EXTRA_PASS, "null"));
                //Log.d("PASS_WR", passDeCoder.hPSCD(password.getText().toString()));
            }
        } else{
            Log.d("EMAIL_SP", permStorageGet.getString(SignupActivity.EXTRA_EMAIL, "null"));
            Log.d("EMAIL_WR", email.getText().toString());
        }
    }
}