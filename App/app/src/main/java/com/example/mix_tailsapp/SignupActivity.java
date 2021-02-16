package com.example.mix_tailsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {
    protected static final String EXTRA_NAME = "com.example.mix_tailsapp.EXTRA_NAME";
    protected static final String EXTRA_EMAIL = "com.example.mix_tailsapp.EXTRA_EMAIL";
    protected static final String EXTRA_PASS = "com.example.mix_tailsapp.EXTRA_PASS";
    protected static final String STORAGE = "SUPERMANisSuperiorThanBatman";

    private EditText name, email, password, confirm_password;
    private TextView signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        //casting the edit text variables to their ids
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.comfirm_password);
        signUp = findViewById(R.id.maintext);



        Button confirm = findViewById(R.id.confirmBtn);
        confirm.setOnClickListener(v -> formSubmitted());
    }
    //create a method for form submitted confirmation
    @SuppressLint("ResourceAsColor")
    public void formSubmitted() {
        Intent conf = new Intent(SignupActivity.this, SignupConfirmationScreen.class);
        SharedPreferences storagePut = getSharedPreferences(STORAGE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = storagePut.edit();
        prefEditor.putString(EXTRA_NAME, name.getText().toString());
        prefEditor.putString(EXTRA_EMAIL, email.getText().toString());

        if(password.getText().toString().equals(confirm_password.getText().toString())){
            prefEditor.putString(EXTRA_PASS, password.getText().toString());
            if(prefEditor.commit()){
                startActivity(conf);
            }
        } else{
            signUp.setText("Passwords don't match :(");
            confirm_password.setTextColor(R.color.red);
        }

    }

}